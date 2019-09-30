<%-- 
    Document   : itemPage
    Created on : 16/08/2019, 5:48:55 PM
    Author     : Calvin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Item Page</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>    
        <div>
            <%
                //Attributes recieved from itemServlet
                Item item = (Item) request.getAttribute("item");
                String error = (String) request.getAttribute("err");

                //String id = request.getParameter("id");
                MongoDBConnector connector = new MongoDBConnector();
                if (item != null) {
            %>
            <div class="mainBox">
                <!-- Display errors -->
                <% if (error.length() > 0) {%>
                <%=error%>
                <%} else {%>
                
                <!-- Item info-->
                <div class="col">
                    <h><%=item.getName()%></h>
                    <p></p> 
                    <img src="<%=item.getImage()%>" style="width:500px; height:400px;"/>
                    <div> Description </div>
                    <div> <%=item.getDescription()%> </div>
                    <hr>
                    <div> Category: <%=item.getCategory()%> </div>
                    <div> Price: $<%=item.getPrice()%> </div>
                    <div> Expiration Date: <%=item.getExpDate()%></div>

  <a href="buyProduct.jsp"> Buy Now! </a>                
                </div>    
                    <!--Shows the seller info of item-->
                <div class="col">
                    <div class="userBox">
                        <div><u> User Info </u></div>
                        <div> Listed User : <a href="./profile?id=<%=item.getSellerID()%>" ><%=connector.getusername(item.getSellerID())%></a></div>                 
                        <div> Listed Date: <%=item.getDateListed()%> </div>
                    </div>
                </div>    
                <% }
                    //Reviews of Item
%>
                <div class="reviewtitlebox">
                    <h2>Item Reviews</h2>
                    <a href="./review?id=<%=item.getID()%>">Leave a Review</a>
                       
                       
                    <form method="post" action="review.jsp">
                        <input type="HIDDEN" name="id" value="<%=item.getID()%>">
                        <input type="HIDDEN" name="name" value="<%=item.getName()%>">
                        <input class="" type="submit" value="Leave a Review">
                    </form> 
                </div>
                <%
                    //This retrieves all review data from the DB that contains the same ItemId as the item
                    ArrayList<Review> reviews = connector.getItemReviews(item.getID());
                    for (Review review : reviews) {
                    //Displays review Title, links to reviewer page and review Description
%>
                <div class="reviewbox">
                    <h3><%=review.getTitle()%></h3>
                    <h5>by <a href="./profile?id=<%=item.getSellerID()%>"><%=connector.getusername(review.getUserID())%></a></h5>
                    <h5><%=review.getDesc()%></h5>
                </div>
                <%  }
                    }
                %>  
            </div>        
        </div>
        <% //connector.closeConnection();%>
    </body>
</html>
