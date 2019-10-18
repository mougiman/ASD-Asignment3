<%-- 
    Document   : addUser
    Created on : 28/09/2019, 12:05:25 PM
    Author     : Calvin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        
        
    </head>
    
    <body>
        <jsp:include page="header.jsp"/>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/BetterASDStyle.css">
    </head>
    <body>
        <%
            ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors");
        %>
        
        <div class="row2">
            <br>
            <br>
            <h>Create an account</h>
        </div>
        
        <% if(errors != null){ %>
            <div class="row2">
            The following issues were found:
            <% for(int i = 0; i < errors.size(); i++){ 
                String msg = errors.get(i); %>
                <div> <%=msg%> </div>
            </div>
        <%}}%>
        
        <div class="row2">
            <div class="addBox">
                <form method="get" action="addUser">
                <div class="signup">
                    <div class="inputbox">
                        <label> ID: </label>
                        <input type="number" name="id" required="">   
                    </div>
                    <div class="inputbox">
                        <label>Full Name:</label>
                        <input type="text" name="name" required="">   
                    </div>
                    <div class="inputbox">
                        <label>Email:</label>
                        <input type="text" name="email" required="">   
                    </div>
                    <div class="inputbox">
                        <label>Password:</label>
                        <input type="password" name="password" required="">   
                    </div>
                    <div class="inputbox">
                        <label>Phone Number:</label>
                        <input type="number" name="phone" required="">   
                    </div>
                    <div class="inputbox">
                        <label>is Admin?</label>
                        <input type="checkbox" name="admin" value="on">   
                    </div>
                </div>
                <div class="row2">
                    <input type="submit" name="submitted" value="Register">
                    &nbsp;&nbsp;&nbsp;
                    <a href="./users" class="btn1"> Back </a>
                </div>
                </form>
            </div>
        </div>
    </body>
</html>

