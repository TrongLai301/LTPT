import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "product_manager_database";
    private String username = "root";
    private String password = "password";
    private String connecttionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connecttionURL, username, password);
            System.out.println("complete connect");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
