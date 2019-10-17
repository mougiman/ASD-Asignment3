<%-- 
    Document   : watchlist
    Created on : 2019-9-28, 16:33:44
    Author     : Cai weize
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>

    <body>        
        <%  // This is code in relation to the local database
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
            if (items.isEmpty()) {
        %>  
        <p>nothing in watchlist</p>
        <%  } else { %> 
        <jsp:include page="./header.jsp"/>
        <div class="container">
            <div class="row">
                <h> Watchlist </h>
            </div>     
            <div class="row">
                <div class="itemList">              
                    <div class="row">
                        <%for (int i = 0; i < items.size(); i++) {
                                    Item item = items.get(i);%>
                        <a href="./item?id=<%=item.getID()%>" class="itemCard">
                            <div class="imageContainer">
                                <span class="helper"></span>
                                <img src="<%=item.getImage()%>"/>
                            </div>
                            <br>
                            <%=item.getName()%>
                            $<%=item.getPrice()%>
                        </a>
                    </div>
                    <% }
                        }%>
                </div>        
            </div>
        </div> 
        <%--<jsp:include page="logout.jsp"/>--%>
    </div>
</body>
</html>