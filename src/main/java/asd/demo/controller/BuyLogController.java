package asd.demo.controller;

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
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String payType = request.getParameter("pay");

        MongoDBConnector connector = new MongoDBConnector();
        connector.saveBuyLog(name, price, payType);
        request.getRequestDispatcher("itemPage.jsp").include(request, response);
    }
}
