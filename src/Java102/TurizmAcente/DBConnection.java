package Java102.TurizmAcente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
    private final String host = "jdbc:postgresql://localhost:5432/";
    private final String db = "turizm";
    private final String user = "postgres";
    private final String password = "1234";
    private Properties props = new Properties();
    private Connection connection = null;

    public DBConnection() {
        tryConnection();
    }

    public boolean tryConnection() {
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl", "flase");

        System.out.println("Connecting to database..."); // Open a connection
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(host + db, props);

            this.connection.setAutoCommit(false); // Set auto commit false
            System.out.println("DB Connection successfully");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
            return false;
        }
    }

    public boolean finallyBlock(Statement statement, DBConnection dbConnection, SQLException se) {
        System.err.println(se.getClass().getName() + ": " + se.getMessage());
        // If there is an error then rollback the changes.
        System.out.println("There is an error / Rolling back data here...");
        try {
            if(dbConnection.getConnection() != null)
                dbConnection.getConnection().rollback();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        } finally {
            // finally block used to close resources
            try {
                if(statement != null)
                    statement.close();
                System.out.println("Closed statement...");
            } catch (Exception e) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
            }
            try {
                if(dbConnection.getConnection() != null)
                    dbConnection.getConnection().close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
            }
        }
        return false;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
