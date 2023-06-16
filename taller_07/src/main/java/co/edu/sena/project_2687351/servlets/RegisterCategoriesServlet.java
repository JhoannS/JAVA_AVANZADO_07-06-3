package co.edu.sena.project.servlets;

import co.edu.sena.project.model.beans.Categories;
import co.edu.sena.project.model.repository.CategoriesRepositoryImpl;
import co.edu.sena.project.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register-Categories")
public class RegisterCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo collect all from data
        String category_name = request.getParameter("category_name");
        //todo fill up in a User bean
        Categories categories = new Categories(category_name);
        //todo call repository layer and save the objects to BD
        Repository<Categories> repository = new CategoriesRepositoryImpl();
        int rows = 0;
        try{
            rows=repository.SaveObj(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //todo prepare an information message for user about succes or failure of the operation
        String infoMessage = null;
        if (rows==0){
            infoMessage="ocurrio un error";
            System.out.println(infoMessage);
        }
        else {
            System.out.println("registrado satisfactoriamente");
        }
    }
}
