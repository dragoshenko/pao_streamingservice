package DataBase;

import model.Album;
import model.Recenzie;
import java.sql.*;
import java.util.*;

public class RecenzieDB {
    private Connection connection;

    public RecenzieDB(Connection connection) {
        this.connection = connection;
    }

    public void create(Recenzie recenzie) throws SQLException {
        String sql = "INSERT INTO recenzie (text, nota, nume_critic, album_id) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, recenzie.getText());
            statement.setDouble(2, recenzie.getNota());
            statement.setString(3, recenzie.getNumeCritic());
            statement.setInt(4, recenzie.getAlbum().getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error on 'recenzie' insert.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    recenzie.setId(generatedKeys.getInt(1)); // Presupunem că Recenzie are un setter pentru id
                } else {
                    throw new SQLException("Creating review failed, no ID obtained.");
                }
            }
        }
    }

    public Recenzie getById(int id) throws SQLException {
        String sql = "SELECT * FROM recenzie WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Album album = new Album();
                    return new Recenzie(
                            resultSet.getString("text"),
                            resultSet.getDouble("nota"),
                            resultSet.getString("nume_critic"),
                            album
                    );
                }
            }
        }
        return null;
    }

    public List<Recenzie> getAllByAlbumId(int albumId) throws SQLException {
        List<Recenzie> reviews = new ArrayList<>();
        String sql = "SELECT * FROM recenzie WHERE album_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, albumId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Album album = new Album(); // Presupunem că Album are constructor fără parametri sau alte metode adecvate
                    reviews.add(new Recenzie(
                            resultSet.getString("text"),
                            resultSet.getDouble("nota"),
                            resultSet.getString("nume_critic"),
                            album // Trebuie să setezi album-ul corect aici
                    ));
                }
            }
        }
        return reviews;
    }

    // Metoda update nu este necesară dacă presupunem că fiecare recenzie este unică și nu trebuie modificată după crearea sa.
    // Dacă acest lucru nu este valabil, veți avea nevoie să implementați logica de actualizare apropriată.
}
