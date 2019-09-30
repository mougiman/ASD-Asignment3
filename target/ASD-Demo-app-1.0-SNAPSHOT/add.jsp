<%-- 
    Document   : Watchlist
    Created on : 2019-9-23, 16:45:42
    Author     : Cai weize
--%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            String Uid = "11111111";

            MongoDBConnector connector = new MongoDBConnector();
            connector.addWatchlist(Uid, id);
            String redirect = "./item?id=" + id;
            response.sendRedirect(redirect);
        %>  
        <p>success</p>
        <a href=".\" class="links">Home</a> 
        <a href="./item?id=<%=id%>"> back </a>
        <a href="./watchlist?id=<%=Uid%>" >> view watch list </a>

    </body>

</html>
