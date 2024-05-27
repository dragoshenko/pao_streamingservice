package DataBase;

import model.GenMuzical;
import java.sql.*;
import java.util.*;

public class GenMuzicalDB {
    private Connection connection;

    public GenMuzicalDB(Connection connection) {
        this.connection = connection;
    }

    public void create(GenMuzical genMuzical) throws SQLException {
        String sql = "INSERT INTO genmuzical (gen) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, genMuzical.getGen());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error on 'genmuzical' insert.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    genMuzical.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating genre failed, no ID obtained.");
                }
            }
        }
    }

    public GenMuzical getById(int id) throws SQLException {
        String sql = "SELECT * FROM genmuzical WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new GenMuzical(resultSet.getString("gen"));
                }
            }
        }
        return null;
    }

    public List<GenMuzical> getAll() throws SQLException {
        List<GenMuzical> genres = new ArrayList<>();
        String sql = "SELECT * FROM genmuzical";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                genres.add(new GenMuzical(resultSet.getString("gen")));
            }
        }
        return genres;
    }

    public void update(GenMuzical genMuzical) throws SQLException {
        String sql = "UPDATE genmuzical SET gen =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, genMuzical.getGen());
            statement.setInt(2, genMuzical.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM genmuzical WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

