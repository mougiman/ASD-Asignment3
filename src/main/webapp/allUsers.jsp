<%-- 
    Document   : allUsers
    Created on : 26/08/2019, 5:33:41 PM
    Author     : Calvin
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
        <% //Stores data from the controller
            ArrayList<User> userList = (ArrayList<User>) request.getAttribute("Users");
            String msg = (String) request.getAttribute("msg");
            String id = (String) request.getAttribute("id");
        %>  
       
        <div class="container">
            <div class="row">
                <h>All Users</h>
            </div>
            <div class="row">
                <a href="addUser.jsp" class="button" name="action" value="add"> Add User</a>
                <div class="message">
                    <% if(msg != null){ %>
                        <u><b><%=msg%></b></u>  
                    <%   }  %>
                </div>
            </div>
            <div class="row">
                <br>
                <table>
                    <!-- Table header -->
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
                            <!-- Checks for delete confirmation -->
                            <% if(user.getID().equals(id)){%>
                            <td colspan="5">
                                Are you sure you want to delete this user?
                                <a href="./deleteUser?id=<%=id%>&confirm=true"> Yes </a>
                                    &nbsp;&nbsp;&nbsp;
                                <a href="./users"> No </a>
                            </td>
                            <%} else {%>
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
                                <a href="./deleteUser?id=<%=user.getID()%>" id="deleteBtn"> Delete </a>
                            </td>
                            <%}%>
                            </tr>
                    <% }%>
                </table>
            </div>
            <div class="row">
                <br>
                    
                <br>
            </div>
        </div>
    </body>
</html>
