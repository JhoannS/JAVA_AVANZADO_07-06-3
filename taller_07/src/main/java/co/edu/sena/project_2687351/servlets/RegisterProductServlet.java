package co.edu.sena.project.servlets;

import co.edu.sena.project.model.beans.Product;
import co.edu.sena.project.model.repository.ProductRepositoryImpl;
import co.edu.sena.project.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register-Product")
public class RegisterProductServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = request.getParameter("product_name");
        Integer product_value = Integer.valueOf(request.getParameter("product_value"));
        Integer category_id = Integer.valueOf(request.getParameter("category_id"));

        Product product = new Product(product_name,product_value,category_id);

        Repository<Product> repository=new ProductRepositoryImpl();
        int rows=0;
        try{
            rows= repository.SaveObj(product);
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
