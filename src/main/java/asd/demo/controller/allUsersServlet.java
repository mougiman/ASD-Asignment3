/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.*;
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

@WebServlet("/allUsersServ")
public class allUsersServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       MongoDBConnector connector = new MongoDBConnector();
       Users userList = connector.getUserList();
       String action = request.getParameter("action");
       request.setAttribute("action", action);
       ArrayList<User> users = userList.getList();
       request.setAttribute("Users", users);
       request.getRequestDispatcher("allUsers.jsp").forward(request, response);
   }
}

