
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

@WebServlet("/allItems")
public class allItemsServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       //Grabs all items from database
       MongoDBConnector connector = new MongoDBConnector();
       ItemList itemList = connector.getItemList();
       ArrayList<Item> items = itemList.getList();
       request.setAttribute("Items", items);
       request.getRequestDispatcher("allItems.jsp").forward(request, response);
   }
}

