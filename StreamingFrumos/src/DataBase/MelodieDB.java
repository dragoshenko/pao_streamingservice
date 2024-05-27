package DataBase;

import model.Melodie;
import java.sql.*;
import java.util.*;

public class MelodieDB {
    private Connection connection;

    public MelodieDB(Connection connection) {
        this.connection = connection;
    }

    public void create(Melodie melodie) throws SQLException {
        String sql = "INSERT INTO melodie (nume, durata, numar_streamuri) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, melodie.getNume());
            statement.setInt(2, melodie.getDurata());
            statement.setInt(3, melodie.getNumarStreamuri());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error on 'melodie' insert.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    melodie.setId(generatedKeys.getInt(1)); // Presupunem că Melodie are un setter pentru id
                } else {
                    throw new SQLException("Creating song failed, no ID obtained.");
                }
            }
        }
    }

    public Melodie getById(int id) throws SQLException {
        String sql = "SELECT * FROM melodie WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Melodie(
                            resultSet.getString("nume"),
                            resultSet.getInt("durata"),
                            resultSet.getInt("numar_streamuri")
                    );
                }
            }
        }
        return null;
    }

    public List<Melodie> getAll() throws SQLException {
        List<Melodie> songs = new ArrayList<>();
        String sql = "SELECT * FROM melodie";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                songs.add(new Melodie(
                        resultSet.getString("nume"),
                        resultSet.getInt("durata"),
                        resultSet.getInt("numar_streamuri")
                ));
            }
        }
        return songs;
    }

    public void update(Melodie melodie) throws SQLException {
        String sql = "UPDATE melodie SET nume =?, durata =?, numar_streamuri =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, melodie.getNume());
            statement.setInt(2, melodie.getDurata());
            statement.setInt(3, melodie.getNumarStreamuri());
            statement.setInt(4, melodie.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM melodie WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
