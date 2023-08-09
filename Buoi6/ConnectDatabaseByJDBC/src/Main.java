import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();
//        String query = "SELECT * FROM user";
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                String email = resultSet.getString("email");
//
//                System.out.println(id + "-" + username + "-" + password + "-" + email);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }



//        String queryUpdate = "UPDATE user SET password = ? WHERE id = ?";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(queryUpdate);
//
//            preparedStatement.setString(1, "bichthuan123");
//            preparedStatement.setInt(2,3);
//
//            int row = preparedStatement.executeUpdate();
//            if (row != 0){
//                System.out.println("complete update " + row);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }


        String queryDelete = "DELETE FROM user WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1,2);
            int row = preparedStatement.executeUpdate();
            if (row != 0){
                System.out.println("Complete delete " + row);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}