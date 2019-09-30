package asd.demo.controller;

import asd.demo.model.Item;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 购买记录
 * @author George
 */
public class BuyLogController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = session.getAttribute("userLogin");
        String itemID = request.getParameter("itemID");
        String payType = request.getParameter("payType");
        String address = request.getParameter("address");

        MongoDBConnector connector = new MongoDBConnector();
        Item item = connector.getItem(itemID);
        connector.saveBuyOrder(item, payType, address, user.getID());
        request.getRequestDispatcher("buyResult.jsp").forward(request, response);
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id"); //Gets item id from url 
        
        String errMsg = "";
        request.setAttribute("err", errMsg);
        //Error checks
        if (item == null) {
            errMsg = "Item not found, Please look for another Item";
            request.setAttribute("err", errMsg);
        }else {
            request.setAttribute("item", item);
        }
        request.getRequestDispatcher("buyProduct.jsp").forward(request, response);
     }
}
