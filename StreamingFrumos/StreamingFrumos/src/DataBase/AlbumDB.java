package DataBase;

import model.Album;
import model.Artist;
import model.GenMuzical;
import java.sql.*;
import java.util.*;

public class AlbumDB {
    private Connection connection;

    public AlbumDB(Connection connection) {
        this.connection = connection;
    }

    public void create(Album album) throws SQLException {
        String sql = "INSERT INTO album (nume, genmuzical_id, artist_id) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, album.getNume());
            statement.setInt(2, album.getGenMuzical().getId());
            statement.setInt(3, album.getArtist().getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error on 'album' insert.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    album.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No ID obtained.");
                }
            }
        }
    }

    public Album getById(int id) throws SQLException {
        String sql = "SELECT * FROM album WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Artist artist = getArtistById(resultSet.getInt("artist_id"));
                    GenMuzical genMuzical = getGenreById(resultSet.getInt("genmuzical_id"));

                    return new Album(
                            resultSet.getString("nume"),
                            genMuzical,
                            artist
                    );
                }
            }
        }
        return null;
    }

    public List<Album> getAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM album";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Artist artist = getArtistById(resultSet.getInt("artist_id"));
                GenMuzical genMuzical = getGenreById(resultSet.getInt("gen_muzical_id"));


                albums.add(new Album(
                        resultSet.getString("nume"),
                        genMuzical,
                        artist
                ));
            }
        }
        return albums;
    }

    private Artist getArtistById(int artistId) throws SQLException {

        return null;
    }

    private GenMuzical getGenreById(int genreId) throws SQLException {

        return null;
    }

}
