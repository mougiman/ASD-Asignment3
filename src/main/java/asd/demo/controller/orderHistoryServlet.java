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
public class orderHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        //Gets item sellerid from url 
        String userID = request.getParameter("id");
        ArrayList<Order> order = connector.getOrderList(userID);
        String errMsg = "";
        request.setAttribute("err", errMsg);
        if (order == null) {
            errMsg = "There are currently no sales to list.";
            request.setAttribute("err", errMsg);      
        } else {
            request.setAttribute("orderHistory", order);
        }
        //connector.closeConnection();
        request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
    }
}