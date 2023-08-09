import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String ip = "localhost";
        String port = "3306";
        String dbName = "demo_jdbc";
        String mysqlConn = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;

        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(mysqlConn, username, password);
        System.out.println("Ket noi thanh cong");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap cau lenh: ");
        String query = "UPDATE user set username = 'trong' where id = 3;";
        Statement statement = conn.createStatement();
        int resultSet = statement.executeUpdate(query);
        System.out.println(resultSet);
//        while (resultSet.next()){
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("username");
//            String pass = resultSet.getString("password");
//            String email = resultSet.getString("email");
//            System.out.println(id + name + pass + email);
//        }

        conn.close();
    }
}