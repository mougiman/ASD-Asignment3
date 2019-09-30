<%-- 
    Document   : rateUser
    Created on : 02/09/2019, 2:57:05 PM
    Author     : mougi
--%>

<%@page import="asd.demo.model.Rating"%>
<%@page import="java.util.Random"%>
<%@page import="asd.demo.model.User"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rating</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>    
        <%
            User user = (User) request.getAttribute("user");
            Rating rating = (Rating) request.getAttribute("rating");
            MongoDBConnector connector = new MongoDBConnector();
            if (user != null) {
                String name = user.getName();
        %>

        <h1>Rating of <%=name%></h1>
        <form class="pure-form pure-form-aligned formbox" action="./ratingMade">
            <fieldset>
                <div class="pure-control-group">
                    <label for="">Rating Title:</label>
                    <input id="" type="text" placeholder="" name="title" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Rating Score:</label>
                    <input id="" type="number" placeholder=""  min="0.00" step="0.01" max="5" name="score" required>
                </div>
                <div class="pure-control-group" >
                    <label for="">Description:</label>
                    <textarea name = "desc" class="pure-input-1-2" placeholder="This user...." required></textarea>
                </div>           
                <input type="HIDDEN" name="rated" value="<%=user.getID()%>">
                <input type="HIDDEN" name="id" value="<%=user.getID()%>">
                <input type="HIDDEN" name="rater" value="11111111">
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
        <%
        } else if (rating != null) {
            connector.addRating(rating);
        %>
        <h2>Thank you for your Rating</h2>
        <a href=".\">Return to main page</a>
           <a href="./profile?id=<%=rating.getSellerID()%>">Return to user <%=connector.getusername(rating.getSellerID())%>'s page</a>
        <%
        } else {
        %>
        <h2>Something went wrong!</h2>
        <a href="index.jsp">Return to main page</a>
        <%
            }
        %>
    </body>
</html>
