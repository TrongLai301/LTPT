import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectToJDBC connectToJDBC = new ConnectToJDBC();
        Connection connection = connectToJDBC.connection();
        Statement statement = null;
        String query = "SELECT * FROM products";
        String queryid3 = "SELECT * FROM products WHERE id = 3";
        String queryid3or5 = "SELECT * FROM products WHERE id = 3 or id = 5";
        String queryStatus = "SELECT * FROM products WHERE status = 0";
        String queryStatusAndNumber = "SELECT * FROM products WHERE status = 1 and number = 9";
        String queryInsert = "INSERT INTO products " + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            //Hien thi thong tin
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(queryStatusAndNumber);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                double price = resultSet.getDouble("price");
//                String detail = resultSet.getString("detail");
//                String manufacturer = resultSet.getString("manufacturer");
//                int number = resultSet.getInt("number");
//                boolean status = resultSet.getBoolean("status");
//
//                System.out.println(id + name + price + detail + manufacturer + number + status);
//        }

            //Cap nhat them mot ban ghi
//        preparedStatement =connection.prepareStatement(queryInsert);
//        preparedStatement.setInt(1,11);
//        preparedStatement.setString(2,"HP");
//        preparedStatement.setDouble(3,203030);
//        preparedStatement.setString(4,"hahah");
//        preparedStatement.setString(5,"none");
//        preparedStatement.setInt(6,9);
//        preparedStatement.setBoolean(7,true);
//        int row = preparedStatement.executeUpdate();
//        if (row!= 0){
//            System.out.println("complete update");
//        }

            //Cap nhat sua ban ghi
//            Scanner scanner = new Scanner(System.in);
//            String column = scanner.nextLine();
//            String values = scanner.nextLine();
//            String queryUpdate = "UPDATE products SET "+ column +"= ? WHERE id = ?";
//            preparedStatement = connection.prepareStatement(queryUpdate);
//            preparedStatement.setString(1, values);
//            preparedStatement.setInt(2,4);
//            int row = preparedStatement.executeUpdate();
//        if (row!= 0){
//            System.out.println("complete update");
//        }

            //xoa du lieu
//            String queryDelete = "DELETE FROM products WHERE id = 4";
//            preparedStatement = connection.prepareStatement(queryDelete);
//            int row = preparedStatement.executeUpdate();
//            if (row != 0){
//                System.out.println("Complete update");
//            }

            //
        connection.close();
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}