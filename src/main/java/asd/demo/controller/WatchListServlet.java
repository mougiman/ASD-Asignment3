/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Item;
import asd.demo.model.ItemList;
import asd.demo.model.User;
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
 * @author Cai weize
 */

@WebServlet("/WLServ")
public class WatchListServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       MongoDBConnector connector = new MongoDBConnector();
       //Gets user id from url 
       String Userid = request.getParameter("id");
     
 ArrayList<Item> items = new ArrayList<Item>();
       
       User user = connector.getUser(Userid);
       String errMsg = "";
       request.setAttribute("err", errMsg);
    //   if(user == null){
     //       request.getRequestDispatcher("login.jsp").forward(request, response);
     //  }
    //   else{
                 ItemList item=connector.getWatchList(user.getID());
                  items = item.getList();
                  
                   
               request.setAttribute("user", user);
            request.setAttribute("items", items);

       
         
           request.getRequestDispatcher("watchlist.jsp").forward(request, response);
               }
               
}
//}
