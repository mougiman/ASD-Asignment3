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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mougi
 */
@WebServlet(name = "RatingController", urlPatterns = {"/RatingController"})
public class RatingController extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id"); //Gets item id from url 
        User user = connector.getUser(id);
        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (user == null) {
            
            errMsg = "User for Rating not found, Please look for another User to Rate.";
            request.setAttribute("err", errMsg);
        }else {
            //set user for rating
            request.setAttribute("user", user);
        }
        request.getRequestDispatcher("rateUser.jsp").forward(request, response);
    }
}
