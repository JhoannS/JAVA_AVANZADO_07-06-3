package co.edu.sena.project.servlets;

import co.edu.sena.project.model.User;
import co.edu.sena.project.model.repository.Repository;
import co.edu.sena.project.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register-user")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_firstname = request.getParameter("user_firstname");
        String user_lastmane = request.getParameter("user_lastmane");
        String user_email = request.getParameter("user_email");
        String user_pasword = request.getParameter("user_pasword");

        User user = new User(user_firstname,user_lastmane,user_email,user_pasword);

        Repository<User> repository = new UserRepositoryImpl();
        int rows=0;
        try{
        rows= repository.SaveObj(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        String infoMesaage = null;
        if (rows==0){
            infoMesaage="Ocurrio un eror";
            System.out.println(infoMesaage);
        }
        else {
            System.out.println("registrado satisfactoriamente");
        }
    }
}
