
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Cart Page</title>
        <style>
            #cartlist{
                width: 100%;
                float: left;
                
            }
            .item{
                width: 150px;
                height: auto;
                margin: 50px;
            }
            img{
                width: 150px;
                height: auto;
            }
            #total{
                float: right;
                margin-right: 200px;
                margin-bottom: 200px;
            }
        
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>My Cart</h1>
        <%
            String userID = ((User)session.getAttribute("userLogin")).getID();
            MongoDBConnector connector = new MongoDBConnector();
            ArrayList<CartItem> cartItems = connector.getCartItemsByUserID(userID);
            double total = 0;
        %>
        <%if(cartItems == null || cartItems.isEmpty()){%>
            <h1>Cart is empty</h1>
        <%}else{%>
        <div>
        <div id="cartlist">
            <% for(int i = 0;i < cartItems.size();i++) {  
                    String id = cartItems.get(i).getItemID();
                    Item item = connector.getItemByID(id);
                    total += item.getPrice();
                    String url = "CartDeleteController?userID="+userID+"&itemID="+item.getID();
            %>
                    <div class="item">
                        <img src="<%=item.getImage()%>"/>
                        <span>Price:<%=item.getName()%></span>
                        <span>Price:<%=item.getPrice()%></span>
                        <div>
                            <a href="<%=url%>"><button>Remove</button></a>
                        </div>
                        
                    </div>
             <%}%>
        </div>  
        <div id="total">
            <div >
            Total Price:$<%=total%>
            </div>
            <%String clearCart = "CartDeleteController?userID="+userID;%>
            <a href="<%=clearCart%>"><button>Clear Cart</button></a>
            <button>Checkout</button>
        </div>
        </div>
        <% } %>
 
    </body>   
</html>
