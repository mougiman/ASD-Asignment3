/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Rating;
import asd.demo.model.User;
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
@WebServlet(name = "RatingMadeController", urlPatterns = {"/RatingMadeController"})
public class RatingMadeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        //String id = request.getParameter("id"); //Gets item id from url 
        //User user = connector.getUser(id);

        Random rand = new Random();
        String ratingid = "" + rand.nextInt(999999);
        String rated = request.getParameter("rated");
        String rater = request.getParameter("rater");
        double score = Double.parseDouble(request.getParameter("score"));
        String desc = request.getParameter("desc");
        String title = request.getParameter("title");
        String date = "" + java.time.LocalDate.now();

        Rating rating = new Rating(ratingid, rated, rater, desc, title, date, "" + score);

        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (rating == null) {
            errMsg = "User for Rating not found, Please look for another User to Rate.";
            request.setAttribute("err", errMsg);
        } else {
            //set rating for upload via page
            connector.addRating(rating);

        }
        request.getRequestDispatcher("./profile?id="+rated).forward(request, response);
    }
}

