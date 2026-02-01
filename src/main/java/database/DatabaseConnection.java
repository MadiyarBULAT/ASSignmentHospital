package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/hospital_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "madiarmadiar2007";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception ignored) {}
    }
}
