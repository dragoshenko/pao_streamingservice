package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/musicdb";
    private static final String username = "postgres";
    private static final String password = "dragos";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexiunea la baza de date a avut succes.");
            } catch (SQLException e) {
                System.out.println("Eroare la inchiderea conexiunii la baza de date!");
                e.printStackTrace();
            }
        }
    }
    public static void deleteInserts(String tableName) throws SQLException {
        String deleteQuery = "DELETE FROM " + tableName;
        Connection connection = DatabaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.executeUpdate();
            System.out.println("Inserturile s-au sters cu succes.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
