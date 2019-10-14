<%-- 
    Document   : addUser
    Created on : 28/09/2019, 12:05:25 PM
    Author     : Calvin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String msg = (String) request.getAttribute("msg");
        %>
        
        
        <div class="signup">
            <h1>Create an account</h1>
            <div style="color: red;">
            <% if(msg != null){ %>
              <%=msg%>  
            <%   }  %>
            </div>
            <form method="get" action="addUser">
            <div class="inputbox">
                <label> ID </label>
                <input type="text" name="id" required="">   
            </div>
            <div class="inputbox">
                <label>Full Name</label>
                <input type="text" name="username" required="">   
            </div>
            <div class="inputbox">
                <label>Email</label>
                <input type="email" name="email" required="">   
            </div>
            <div class="inputbox">
                <label>Password</label>
                <input type="password" name="password" required="">   
            </div>
            <div class="inputbox">
                <label>Phone Number</label>
                <input type="text" name="phone" required="">   
            </div>
            <div class="inputbox">
                <label>is Admin?</label>
                <input type="checkbox" name="admin">   
            </div>
                <input type="submit" name="submitted" value="Register">
                <a href="./users" class="button"> Back </a>
            </form>
        </div>
    </body>
</html>

