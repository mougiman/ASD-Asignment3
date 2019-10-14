<%-- 
    Document   : buyProduct
    Created on : 23/09/2019, 12:52:15 AM
    Author     : lee
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy a product Page</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
          
    </head>
    <body>
        <h1>Product review</h1>
        <jsp:include page="header.jsp"/>    
        
        <%
                String error = (String) request.getAttribute("err");
                MongoDBConnector connector = new MongoDBConnector();
                if (error == null) {
            %>
            <h1>Success</h1>
            <a href="header.jsp">Go Home</a>
       <%
       }
       %>
 
 
    </body>
</html>
