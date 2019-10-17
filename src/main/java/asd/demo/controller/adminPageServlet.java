/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Item;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Calvin
 */

@WebServlet("./adminServ")
public class adminPageServlet extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       
       String id = (String) request.getAttribute("id");
       MongoDBConnector connector = new MongoDBConnector();
       User user = connector.getUser(id);
       request.setAttribute("name", user.getName());
       request.getRequestDispatcher("adminPage.jsp").forward(request, response);
   
   }
}
