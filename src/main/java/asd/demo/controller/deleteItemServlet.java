
package asd.demo.controller;

import asd.demo.model.Item;
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
@WebServlet("/deleteItem")

public class deleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Setting itemlist
        MongoDBConnector connector = new MongoDBConnector();
        ArrayList<Item> items = connector.getItemList().getList();
        request.setAttribute("Items", items);
        
        String id = request.getParameter("id");
        
        //Validation for confirmation
        if(request.getParameter("confirm") == null){
            request.setAttribute("id", id);
            request.getRequestDispatcher("allItems.jsp").forward(request, response);
        }
        
        //Deletes item from database
        connector.deleteItem(id);
        request.setAttribute("msg", "Item " +  id + " has been removed.");
        request.getRequestDispatcher("allItems.jsp").forward(request, response);
    }
}
