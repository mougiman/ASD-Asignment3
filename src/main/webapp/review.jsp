<%-- 
    Document   : review
    Created on : 02/09/2019, 2:35:16 PM
    Author     : mougi
--%>

<%@page import="java.util.Random"%>
<%@page import="asd.demo.model.Item"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave a Review</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>  
        <%
            Item item = (Item) request.getAttribute("item");
            String error = (String) request.getAttribute("err");

            //String id = request.getParameter("id");
            MongoDBConnector connector = new MongoDBConnector();
            if (item != null) {

                //This pulls parametes from the item page, so that the listed review contains the right ItemId
                String itemid = item.getID();
                String title = request.getParameter("title");
                String name = request.getParameter("name");

                if (title == null) {            //if the page has not retrieved the title of the review, display form, or else display success message
        %>
        <h1>Review of <%=name%></h1>
        <form class="pure-form pure-form-aligned formbox" action="./review?id=<%=item.getID()%>">
            <fieldset>
                <div class="pure-control-group">
                    <label for="">Review Title:</label>
                    <input id="" type="text" placeholder="" name="title" required>
                </div>
                <div class="pure-control-group" >
                    <label for="">Description:</label>
                    <textarea name = "desc" class="pure-input-1-2" placeholder="This item...." required></textarea>
                </div>           
                <input type="HIDDEN" name="item" value="<%=item%>">
                <input type="HIDDEN" name="userid" value="11111111">
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
        <%
        } else {
            //after refreshing page and retrieveing data, add review to database
            String userid = request.getParameter("userid");
            Random rand = new Random();
            String id = "" + rand.nextInt(999999);
            String desc = request.getParameter("desc");
            String DateListed = "" + java.time.LocalDate.now();
            //This function add reviews to database
            connector.addReview(id, itemid, userid, desc, title, DateListed);
            //display Success message
        %>
        <h2>Thank you for your review</h2>
        <a href=".\">Return to main page</a>
        <a href="./item??id=<%=itemid%>">Return to item's page</a>

        <%            }
        } else {
            //display failure message
        %>
        <div class="mainBox">
            <div class="col">
                <h>Something went wrong!</h>
            </div>
        </div>
    </div>
    <%
        }
    %>
</body>
</html>
