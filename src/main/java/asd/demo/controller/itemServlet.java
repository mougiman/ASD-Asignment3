package asd.demo.controller;

import asd.demo.model.*;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calvin
 */
@WebServlet("/itemServ")
public class itemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id"); //Gets item id from url 
        Item item = connector.getItem(id);
        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (item == null) {
            errMsg = "Item not found, Please look for another Item.";
            request.setAttribute("err", errMsg);
        } else if (item.ifAuc() == true) {
            request.setAttribute("item", item);
            //connector.closeConnection();
            request.getRequestDispatcher("AitemPage.jsp").forward(request, response);

        } else {
            request.setAttribute("item", item);
        }
        //connector.closeConnection();
        request.getRequestDispatcher("itemPage.jsp").forward(request, response);
    }
}
