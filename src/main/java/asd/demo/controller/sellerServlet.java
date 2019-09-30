/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.*;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author gusck
 */
@WebServlet("/sellerServ")
public class sellerServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       MongoDBConnector connector = new MongoDBConnector();
       //Gets user id from url 
       String ID = request.getParameter("id");
       User user = connector.getUser(ID);
       String errMsg = "";
       // error checks
       request.setAttribute("err", errMsg);
       if(user == null){
           errMsg = "User not found, Please look for another User.";
           request.setAttribute("err", errMsg);
       }
       else{
            request.setAttribute("user", user);
       }
       request.getRequestDispatcher("viewUser.jsp").forward(request, response);
   }
}
        //connector.closeConnection();

