
package asd.demo.controller;

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
 * @author Calvin
 */
@WebServlet("/deleteUser")

public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        MongoDBConnector connector = new MongoDBConnector();
        String id = request.getParameter("id");
       
        //Validation for confirmation
        if(request.getParameter("confirm") == null){
            request.setAttribute("id", id);
            ArrayList<User> users = connector.getUserList().getList();
			request.setAttribute("Users", users);
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
        }
        else{
            //Deletes user from database
            connector.deleteUser(id);
            request.setAttribute("msg", "User " + id + " has been deleted.");
			ArrayList<User> users = connector.getUserList().getList();
			request.setAttribute("Users", users);
            request.getRequestDispatcher("allUsers.jsp").forward(request, response);
        }
		
		
        
    }
}
