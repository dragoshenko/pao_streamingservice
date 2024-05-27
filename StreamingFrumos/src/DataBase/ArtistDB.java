package DataBase;
import model.Artist;
import java.sql.*;
import java.util.*;

public class ArtistDB {
    private Connection connection;

    public ArtistDB(Connection connection) {
        this.connection = connection;
    }

    public void create(Artist artist) throws SQLException {
        String sql = "INSERT INTO artist (numeArtist, numeScena, varsta) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, artist.getNume());
            statement.setString(2, artist.getNumeScena());
            statement.setInt(3, artist.getVarsta());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error on 'artist' insert.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    artist.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating artist failed, no ID obtained.");
                }
            }
        }
    }

    public Artist getById(int id) throws SQLException {
        String sql = "SELECT * FROM artist WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Artist(
                            resultSet.getString("numeArtist"),
                            resultSet.getString("numeScena"),
                            resultSet.getInt("varsta")
                    );
                }
            }
        }
        return null;
    }

    public List<Artist> getAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artist";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                artists.add(new Artist(
                        resultSet.getString("numeArtist"),
                        resultSet.getString("numeScena"),
                        resultSet.getInt("varsta")
                ));
            }
        }
        return artists;
    }

    public void update(Artist artist) throws SQLException {
        String sql = "UPDATE artist SET numeArtist =?, numeScena =?, varsta =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, artist.getNume());
            statement.setString(2, artist.getNumeScena());
            statement.setInt(3, artist.getVarsta());
            statement.setInt(4, artist.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM artist WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

