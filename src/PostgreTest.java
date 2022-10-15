import java.sql.*;
import java.util.Properties;

/*
  ResultSet interface’de sorgu sonucunda gelen kayıtlara erişimde;

  “next”: bir sonraki satıra geçer. Okunacak kayıt kalmadığında “false” döner.
  “first”: sorgu sonuç kümesindeki ilk elemana erişim sağlar.
  “last”: sorgu sonuç kümesindeki son elemana erişim sağlar.
  “absolute”: sorgu sonuç kümesinde indeksi verilen elemana erişim sağlar.
 */

public class PostgreTest {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        String createTableSql = "CREATE TABLE COMPANY " +
                "(ID INT PRIMARY KEY NOT NULL, " +
                "NAME TEXT NOT NULL, " +
                "AGE INT NOT NULL, " +
                "ADDRESS CHAR(50), " +
                "SALARY REAL)";

        String insertSql1 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (1, 'Paul', 32, 'California', 20000.00 );";

        String insertSql2 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";

        String insertSql3 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";

        String insertSql4 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";

        String insertSql5 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (5, 'David', 55, 'Miami', 30000.00 );";

        String insertSql6 = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (6, 'Rivaldo', 45, 'Holly Wood', 40000.00 );";

        String updateSql = "UPDATE COMPANY SET SALARY = 25000.00 WHERE ID=1;";
        String deleteSql = "DELETE from COMPANY where ID = 2;";
        String listSql = "SELECT * FROM COMPANY;";

        // dbConnection.executeQuery(createTableSql);
        dbConnection.executeQuery(insertSql1);
        dbConnection.executeQuery(updateSql);
        dbConnection.executeQuery(deleteSql);
        dbConnection.listTable(listSql);
    }
}

class DBConnection {
    private final String host = "jdbc:postgresql://localhost:5432/";
    private final String db = "javaTest";
    private final String user = "postgres";
    private final String password = "12345";
    Properties props = new Properties();
    private Connection connection = null;

    public DBConnection() {
        tryConnection();
    }

    public void tryConnection() {
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl", "flase");

        System.out.println("Connecting to database..."); // Open a connection
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(host + db, props);

            this.connection.setAutoCommit(false); // Set auto commit false
            System.out.println("DB Connection successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }

    // PreparedStatement ? ile kullanım sağlar. Onunla ilgili örnekler de yapılabilir.

    public void executeQuery(String sql) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            this.connection.commit();
            statement.close();
            this.connection.close();
        } catch (SQLException se) {
            System.err.println(se.getClass().getName()+": "+ se.getMessage());
            System.exit(0);
            // If there is an error then rollback the changes.
            System.out.println("Rolling back data here....");
            try {
                if(connection != null)
                    connection.rollback();
            } catch (Exception e) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
                System.exit(0);
            } finally {
                // finally block used to close resources
                try {
                    if(statement != null)
                        statement.close();
                } catch (Exception e) {
                    System.err.println(e.getClass().getName()+": "+ e.getMessage());
                    System.exit(0);
                }
                try {
                    if(connection != null)
                        connection.close();
                } catch (Exception e) {
                    System.err.println(e.getClass().getName()+": "+ e.getMessage());
                    System.exit(0);
                }
            }
        }
    }

    public void listTable(String sql) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.beforeFirst(); // Ensure we start with first row

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("ID: " + id + "\n" + // Display values
                        "NAME: " + name + "\n" +
                        "AGE: " + age + "\n" +
                        "ADDRESS: " + address + "\n" +
                        "SALARY: " + salary + "\n");
            }

            // Clean-up environment
            rs.close();
            statement.close();
            this.connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }
}