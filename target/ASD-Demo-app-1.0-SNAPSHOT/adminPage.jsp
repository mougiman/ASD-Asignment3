<%-- 
    Document   : adminPage
    Created on : 26/08/2019, 4:37:48 PM
    Author     : Calvin
--%>
<%@page import="asd.demo.model.*"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%
            String name = (String) request.getAttribute("name");
            String err = (String) request.getAttribute("err");
        %>
        <div class="col">
            <h> Admin page</h>
        </div>
        <div class="container">
            <% if(err != null){ %>
                User Not Found
            <%} else{%>
            <div class="col">
                
                <div> Username: <%=name%> </div> 
                
            </div>
            <div class="col">
                <a href="./users" class="button"> Manage users </a>
                <a href="./allItems" class="button" name="allItemsBtn"> Manage listings </a>
            </div>
                <%}%>
        </div>
        <div class="row" style="height:100px">  
        </div>
    </body>
</html>
