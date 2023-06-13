package co.edu.sena.project.model.repository;
import java.sql.*;
import java.util.List;
public interface Repository<T> {
    List<T> listAllObj() throws SQLException;

    T byIdObj(Integer id) throws SQLException;

    Integer SaveObj(T t) throws SQLException;

    void deleteObj(Integer id) throws SQLException;

    T createObj(ResultSet rs)  throws  SQLException;
}
