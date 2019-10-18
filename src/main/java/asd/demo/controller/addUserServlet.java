
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<String> errors = new ArrayList<String>();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        
        //Validation for email structure
        String email = request.getParameter("email");
        if(!email.contains("@") || !email.contains(".")){
            errors.add("Please enter valid email");
        }
        
        //Validation for password length
        String password = request.getParameter("password");
        if(password.length() < 8){
            errors.add("Password must have at least 8 characters");
        }
        
        //Validation for phone length
        String phone = request.getParameter("phone");
        System.out.println(phone.length());
        if(phone.length() != 10){
            errors.add("Phone number must be 10 numbers");
        }
        
        Boolean isAdmin;
        String admin = request.getParameter("admin");
        //Shows true if admin checkbox is checked
        if(admin != null){
             isAdmin = true;
        }
        else{
            isAdmin = false;
        }
        
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("addUser.jsp").forward(request, response);
        }
        else{
            //Adding new user to database
            connector.addAUser(id, name, email, password, phone, isAdmin);

            //Setting Success Message
            String message = name + " has been Successfully Registered";
            request.setAttribute("msg", message);   
        }
        ArrayList<User> users = connector.getUserList().getList();
        request.setAttribute("Users", users);
        request.getRequestDispatcher("allUsers.jsp").forward(request, response);
    }
}