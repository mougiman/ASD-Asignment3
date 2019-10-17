<%-- 
    Document   : salesHistory
    Created on : Sep 22, 2019, 9:56:05 PM
    Author     : Changkeun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Order History</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>    
        <div>
                            <h2>Order History</h2>
            <%
                String UserID = request.getParameter("id");
                MongoDBConnector connector = new MongoDBConnector();
                ArrayList<Order> orders = connector.getOrderList(UserID);
                String error = (String) request.getAttribute("err");
                for (Order order : orders) {
                    if (order != null) {
            %>
            <div class="orderHistory">
                <!-- Display errors -->
              <% if (order==null) {%>
                <%=error%>
                <%} else {%>

                <div class="col">
                    <div> Item : <a href="./item?id=<%=order.getItemID()%>" ><%=connector.getitemname(order.getItemID())%></a></div>                 
                    <div> Date: <%=order.getDateListed()%> </div>
                    <div> Address: <%=order.getAddress()%> </div>
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
