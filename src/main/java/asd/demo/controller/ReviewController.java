/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Item;
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
@WebServlet(name = "ReviewController", urlPatterns = {"/ReviewController"})
public class ReviewController extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id"); //Gets item id from url 
        Item item = connector.getItem(id);
        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (item == null) {
            errMsg = "Item for Review not found, Please look for another Item to Review.";
            request.setAttribute("err", errMsg);
        }else {
            request.setAttribute("item", item);
        }
        request.getRequestDispatcher("review.jsp").forward(request, response);
    }
    
}
