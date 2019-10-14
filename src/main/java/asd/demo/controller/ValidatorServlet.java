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
 *
 * @author George
 */
public class ValidatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;

        MongoDBConnector connector = new MongoDBConnector();

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Incorrect email format");    

            request.getRequestDispatcher("login.jsp?emailErr=1").include(request, response);
        } else if (!validator.validatePassword(password)) {
           session.setAttribute("passErr", "Incorrect password format");
            request.getRequestDispatcher("login.jsp?passErr=1").include(request, response);
        } else {
             user = connector.userExists(email, password);
             if(user == null){
                 session.setAttribute("existErr", "User does not exist!");
                request.getRequestDispatcher("login.jsp?nouser=1").include(request, response);
             }else if(user.getPassword() == null){
                  session.setAttribute("passErr", "Incorrect password!");
                request.getRequestDispatcher("login.jsp?passErr=1").include(request, response);
             }else{
                 session.setAttribute("userLogin", user);
                 request.getRequestDispatcher("./").include(request, response);
             }
            
        }
    }
}
