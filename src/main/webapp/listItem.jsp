<%-- 
    Document   : listItem
    Created on : 11/08/2019, 3:29:51 PM
    Author     : Mougi
--%>

<%@page import="asd.demo.model.User"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
    </head>

    <body>
        <jsp:include page="header.jsp"/>

                <h1>List an Item</h1>
        <!--If user is logged in then show the user form, all data is required-->
            <% 
                User user = (User) session.getAttribute("userLogin"); 
                   if (user != null){  
            %>          
        
        <%  // This establishes the connection to the MongoDBConnector
            MongoDBConnector connector = new MongoDBConnector();
            //this is code that changes the page depending on if the user has listed an item properly
            String itemName = request.getParameter("itemName");
            if (itemName == null) {
        %>
                      
            
        <form class="pure-form pure-form-aligned formbox" method="post" action="listItem.jsp" >
            <fieldset>
                <div class="pure-control-group">
                    <label for="">Name:</label>
                    <input id="" type="text" placeholder="" name="itemName" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Category:</label>
                    <select name="itemCategory" required>
                        <option value="fashion">Fashion</option>
                        <option value="electronics">Electronics</option>
                        <option value="everyday essentials">Everyday Essentials</option>
                        <option value="food $ drinks">Food $ Drinks</option>
                        <option value="motors">Motors</option>
                        <option value="homes & gardens">Homes & Gardens</option>
                        <option value="collectables $ art">Collectables $ Art</option>
                        <option value="toys & media">Toys & Media</option>
                        <option value="sporting goods">Sporting Goods</option>
                        <option value="health & beauty">Health & Beauty</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <div class="pure-control-group">
                    <label for="">Quantity:</label>
                    <input id="" type="number" min="0.01" step="0.01" max="2500" placeholder="" name="itemQuantity" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Price:</label>
                    <input id="" type="number" min="0.01" step="0.01" max="99999.99" placeholder="" name="itemPrice" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Image (URL only):</label>
                    <input id="" type="text" placeholder="https://..." name="img" required>
                </div>
                <div class="pure-control-group" >
                    <label for="">Description:</label>
                    <textarea name = "itemDesc" class="pure-input-1-2" placeholder="This item...." required></textarea>
                </div>             
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
        <%
        } else {
            //Once the page sumbits info, it refreshes itself and stores the data in the connected database
            String itemCategory = request.getParameter("itemCategory");
            String itemDesc = request.getParameter("itemDesc");
            Double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            String itemDateListed = "" + java.time.LocalDate.now();
            int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
            String itemSellerID = user.getID();
            Random rand = new Random();
            String itemID = "" + rand.nextInt(999999999);
            String img = request.getParameter("img");
            String expdate = request.getParameter("expdate");
            Boolean ifAuc = false;
            //this calls a method to input data in the DB
            connector.addItem(itemID, itemName, itemDateListed, itemQuantity, itemPrice, itemDesc, itemCategory, itemSellerID, expdate, ifAuc, img);
        %>
        <h3><%=itemName%> has been Listed</h3>
        <a href="listItem.jsp">List another item</a>
        <%
            }
}else{
        %>
        <p>You must be logged in to list an item</p>
        <p>Log in <a href="login.jsp">here</a></p>
        <p>Register a new account <a href="register.jsp">here</a></p>
        <%
            }
            %>
    </body>
</html>
