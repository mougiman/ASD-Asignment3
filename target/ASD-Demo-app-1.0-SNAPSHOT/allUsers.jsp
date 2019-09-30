<%-- 
    Document   : allUsers
    Created on : 26/08/2019, 5:33:41 PM
    Author     : Calvi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        
        
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <% //Stores the data from the controller
             ArrayList<User> userList = (ArrayList<User>) request.getAttribute("Users");
        %>  
        <div class="container">
            <div class="row">
                <h>All Users</h>
            </div>
            <div class="row">
                <a href="./addUserPage" name="action" value="add"> Add User</a>
            </div>
            <div class="row">
                <br>
                <table>
                    <tr>
                       <th> ID </th>
                       <th> Name</th>
                       <th> Email </th>
                       <th> Password</th>
                       <th> Phone </th>
                       <th> is Admin </th>
                       <th> Delete </th>
                    </tr>
                    <!--- Displays all users in a table --->
                    <% for(int i = 0; i < userList.size(); i++){ 
                        User user = userList.get(i); %>
                        <tr>
                            <td> 
                                <%=user.getID()%>
                            </td>
                            <td>
                                <%=user.getName()%>
                            </td>
                            <td>
                                <%=user.getEmail()%>
                            </td>
                            <td>
                                <%=user.getPassword()%>
                            </td>
                            <td>
                                <%=user.getPhone()%>
                            </td>
                            <td>
                                <%=user.getIsAdmin()%>
                            </td>
                            <td>
                                <a href="./users" name="action" value="delete"> Delete</a>
                            </td>
                        </tr>
                    <% }%>
                </table>
                
            </div>
        </div>
    </body>
</html>