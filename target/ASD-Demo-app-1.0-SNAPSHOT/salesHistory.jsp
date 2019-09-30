<%-- 
    Document   : salesHistory
    Created on : Sep 22, 2019, 9:56:05 PM
    Author     : Changkeun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.controller.*"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sales History</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>    
        <div>
            <%
                String sellerId = request.getParameter("id");
                MongoDBConnector connector = new MongoDBConnector();
                ArrayList<Item> items = connector.getItemList(sellerId);
                String error = (String) request.getAttribute("err");
                for (Item item : items) {
                if (item != null) {
            %>
            <div class="salesHistory">
                <!-- Display errors -->
                <% if (error.length() > 0) {%>
                <%=error%>
                <%} else {%>
                                    <h2>Sales History</h2>>

                <div class="col">
                    <p><img src="<%=item.getImage()%>" style="width:100px; height:100px;"/><%=item.getName()%></p>                
                    <div> Category: <%=item.getCategory()%> </div>
                    <div> Price: $<%=item.getPrice()%> </div>
                    <div> Expiration Date: <%=item.getExpDate()%></div>
                    <hr>
                </div>    
            </div> 
        <%                   
                    }
                    }
                    }
        %>
        </div>
        <% //connector.closeConnection();%>
    </body>
</html>