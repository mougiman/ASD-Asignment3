
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calvin
 */

@WebServlet("/addUser")

public class addUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id");
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Boolean isAdmin;
        if((request.getParameterValues("admin")).equals("on")){
            isAdmin = true;
        }
        else{
            isAdmin = false;
        }
        connector.add(new User(id, name, email, password, phone, isAdmin));
        String message = "User Added";
        request.setAttribute("msg", message);
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }
}