import database.DatabaseConnection;
import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            if (conn != null) {
                System.out.println("CONNECTED TO DATABASE ");
                conn.close();
            } else {
                System.out.println("FAILED TO CONNECT ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
