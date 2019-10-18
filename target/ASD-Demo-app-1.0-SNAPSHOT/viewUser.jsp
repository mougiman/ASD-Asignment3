<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="asd.demo.model.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="asd.demo.controller.*"%>
<%@page import="asd.demo.model.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    </head>
    <jsp:include page="header.jsp"/>

    <body>        
        <% 
            User user = (User) request.getAttribute("user");
            String error = (String) request.getAttribute("err");
            MongoDBConnector connector = new MongoDBConnector();
        %>    
       
        <%
             if(session.getAttribute("userLogin") != null){
             if (user != null){  
        %>
        <!-- Display errors -->

        <div>
            <div class="col-sm-12">
                <div class="col-sm-2"></div>
                <% if (error.length() > 0) {%>
                <%=error%>
                <%} else {%>
                <!-- User info-->

                <div class="col-sm-8">
                    <h2 class="text-center"><%=connector.getusername(user.getID())%>'s Profile</h2>
                    <table class="table table-striped">
                        <tr>
                            <td>Name</td>
                            <td>User Score</td>
                            <td>Phone</td>
                            <td>Email</td>
                        </tr>
                        <tr>
                            <td><%=user.getName()%></td>
                            <td><%=connector.getUserScore(user.getID())%></td>
                            <td><%=user.getPhone()%></td>
                            <td><%=user.getEmail()%></td>                       
                        </tr>
                        <tr>
                            <td class="text-center" colspan="4">
                                <button onclick="location.href = './sales?id=<%= user.getID()%>'" class="btn btn-primary">Sales History</button>

                                <button onclick="location.href = './orderHistory?id=<%= user.getID()%>'" class="btn btn-warning">Order History</button>
                            </td>    
                        </tr> 
                    </table>       
                </div>
                <div>
                </div> <!-- col-sm-12 -->
            </div><!-- row -->
            <div class="text-center">
                <!-- Rating  user-->
                <h2>User Ratings</h2>
                <a href="./rating?id=<%=user.getID()%>">Leave a Rating</a>
            </div>
            <%
                ArrayList<Rating> ratings = connector.getUserRatings(user.getID());
                for (Rating rating : ratings) {
            %>
            <div class="reviewbox">
                <h3><%=rating.getTitle()%></h3>
                <h5>Date Listed: <%=rating.getDateListed()%></h5>
                <h5>Score: <%=rating.getScore()%>/5.0</h5>
                <h5>by <%=connector.getusername(rating.getUserID())%></h5>
                <h4><%=rating.getDesc()%></h4>
            </div>

            <%
                }
            %>
        </div>
        <% }%>
        <%
            }}else{
        %>
        <div class="alert alert-danger">          
        <h2><strong>You must be logged in to User Profile page</strong></h2>
            </div>
        <h3>Log in <a href="login.jsp">here</a></h3>
        <h3>Register a new account <a href="register.jsp">here</a></h3>
        <%
            }
         %>
    </body>
</html>
    </body>
</html>    

