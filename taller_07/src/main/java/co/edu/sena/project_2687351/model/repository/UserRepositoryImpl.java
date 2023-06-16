package co.edu.sena.project.model.repository;
import co.edu.sena.project.model.User;
import co.edu.sena.project.ConnectionTest.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User>{

    private String sql = null;

    @Override
    public List<User> listAllObj() throws SQLException {
        sql = "select user_id, user_firstname, user_lastname, user_email, user_password from users_tbl order by user_firstname, user_lastname;";
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User u = createObj(rs);
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public User byIdObj(Integer id) throws SQLException {
        sql = "select user_id, user_firstname, user_lastname, user_email, user_password from users_tbl where user_id = ?;";
        User user = null;

        try (
                Connection conn = ConnectionPool.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    user = createObj(rs);
                }
            }
        }
        return user;
    }

    @Override
    public Integer SaveObj(User user) throws SQLException {
        int rowsAffected = 0;

        if(user.getUser_id() != null && user.getUser_id() > 0){
            sql = "update users_tbl set user_firstname = ?, user_lastname = ?, user_email = ?, user_password = aes_encrypt(?, '$2a$12$71SJ2B6qdXDQrZUF4KR5suDytQ062kLQf/QHbatSw8wLqu1DoMppm') where user_id = ?";
        } else{
            sql = "insert into users_tbl (user_firstname, user_lastname, user_email, user_password) values ( upper(?), upper(?), lower(?), aes_encrypt(?,'$2a$12$71SJ2B6qdXDQrZUF4KR5suDytQ062kLQf/QHbatSw8wLqu1DoMppm'))";
        }

        try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, user.getUser_firstname());
            ps.setString(2, user.getUser_lastmane());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_pasword());
            if(user.getUser_id() != null && user.getUser_id() > 0){
                ps.setInt(5, user.getUser_id());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from users_tbl where user_id = ?";
        try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    @Override
    public User createObj(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_firstname(rs.getString("user_firstname"));
        user.setUser_lastmane(rs.getString("user_lastname"));
        user.setUser_email(rs.getString("user_email"));
        user.setUser_pasword(rs.getString("user_password"));
        return user;    }
}
