package co.edu.sena.project.ConnectionTest;
import java.sql.*;
public class UseConnectionPool {
    private static Connection getConnection()
            throws SQLException {
        return ConnectionPool.getConnection();
    }

    public static void main(String[] args)
            throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt =
                     conn.createStatement();
             ResultSet rs =
                     stmt.executeQuery("SELECT * FROM myapp.users_tbl , myapp.category_tbl , myapp.products_tbl")) {


            {
                while (rs.next()) {


                    System.out.print(rs.getString("user_firstname"));
                    System.out.print(" | ");

                    System.out.println(rs.getString("user_lastname"));

                    System.out.println(rs.getString("category_id"));
                    System.out.print(" | ");
                    System.out.println(rs.getString("category_name"));

                    System.out.println(rs.getString("product_id"));
                    System.out.print(" | ");
                    System.out.println(rs.getString("product_name"));
                    System.out.print(" | ");
                    System.out.println(rs.getString("product_value"));
                }
            }
        }
    }
}

