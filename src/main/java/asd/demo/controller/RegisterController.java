/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.*;
import asd.demo.model.dao.MongoDBConnector;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chenkun
 */
@WebServlet("/reg-login")
public class RegisterController extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            MongoDBConnector connector = new MongoDBConnector();
            String username = request.getParameter("username"); //Get username
            String mail = request.getParameter("email");  //Get email
            String password = request.getParameter("password"); //Get password
            String num = request.getParameter("phone"); //Get phone num
            Random rand = new Random();
            String userID = "" + rand.nextInt(999999999);
            
            connector.addUser(userID, username, mail, password, num); //Add a new user to the User Collection
            //System.out.println("You have successfully registered");
            request.getRequestDispatcher("login.jsp").forward(request, response); //Dircted to the Login page
    }

}
