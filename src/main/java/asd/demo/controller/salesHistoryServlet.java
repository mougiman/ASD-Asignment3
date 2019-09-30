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
@WebServlet("/salesServ")
public class salesHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        //Gets item sellerid from url 
        String sellerId = request.getParameter("id");
        ArrayList<Item> item = connector.getItemList(sellerId);
        String errMsg = "";
        request.setAttribute("err", errMsg);
        if (item == null) {
            errMsg = "There are currently no sales to list.";
            request.setAttribute("err", errMsg);      
        } else {
            request.setAttribute("item", item);
        }
        //connector.closeConnection();
        request.getRequestDispatcher("salesHistory.jsp").forward(request, response);
    }
}