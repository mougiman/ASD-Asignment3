/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Rating;
import asd.demo.model.Review;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mougi
 */
@WebServlet(name = "ReviewMadeController", urlPatterns = {"/ReviewMadeController"})
public class ReviewMadeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        //String id = request.getParameter("id"); //Gets item id from url 
        //User user = connector.getUser(id);

        String userid = request.getParameter("userid");
        String title = request.getParameter("title");
        String itemid = request.getParameter("itemid");
        Random rand = new Random();
        String id = "" + rand.nextInt(999999);
        String desc = request.getParameter("desc");
        String DateListed = "" + java.time.LocalDate.now();
        //This function add reviews to database

        Review review = new Review(id, itemid, userid, desc, title, DateListed);
        
        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (review == null) {
            errMsg = "Item for Review not found, Please look for another Item to Review.";
            request.setAttribute("err", errMsg);
        } else {
            //request.setAttribute("rating", rating);
            connector.addReview2(review);
        }
        request.getRequestDispatcher("./item?id=" + itemid).forward(request, response);
    }
}
