package co.edu.sena.project.model.repository;

import co.edu.sena.project.model.User;

import java.sql.*;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();
            System.out.println("==========Save obj Insert==========");
            User userInsert = new User();
            userInsert.setUser_firstname("Jhoan");
            userInsert.setUser_lastmane("Zamudio");
            userInsert.setUser_email("example@gmail.com");
            userInsert.setUser_pasword("qwertyuiop0");
            repository.SaveObj(userInsert);
            userInsert.setUser_firstname("Sebastianza");
            userInsert.setUser_lastmane("Marulanda");
            userInsert.setUser_email("example2@gmail.com");
            userInsert.setUser_pasword("asdfghjklñ");
            repository.SaveObj(userInsert);

            System.out.println("=========listAllObj============");
            repository.listAllObj().forEach(System.out::println);
            System.out.println();

            System.out.println("==========SaveObj(Update)===========");
            User userUpdate= new User();
            userUpdate.setUser_id(2);
            userUpdate.setUser_firstname("Maicol");
            userUpdate.setUser_lastmane("Juares");
            userUpdate.setUser_email("example3@gmail.com");
            userUpdate.setUser_pasword("zxcvbnm");
            repository.SaveObj(userUpdate);
            repository.listAllObj().forEach(System.out::println);
            System.out.println();

            System.out.println("=========deleteObj=========");
            repository.deleteObj(2);
            repository.listAllObj().forEach(System.out::println);
    }
}
