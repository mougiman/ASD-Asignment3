<%@page import="asd.demo.model.User"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.Random"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">       
    <head>
        <meta charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type=text/javascript> type = "text/javascript" ></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js" type="text/javascript"></script>      
        <script type="text/javascript">


            $(document).ready(function () {
                $('#auctionform').validate({
                    rules: {
                        itemName: {
                            required: true,
                            textonly: true,
                            maxlength: 20
                        },
                        itemC: {
                            required: true

                        },
                        itemDesc: {
                            required: true

                        },
                        itemQ: {
                            required: true,
                            digits: true


                        },
                        itemPrice: {
                            required: true,
                            digits: true

                        },
                        expdate: {
                            required: true,
                        }
                    }


                });

            });

        </script>





        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">

    </head>
    <jsp:include page="header.jsp"/>
    <body>

        <%
            User user = (User) session.getAttribute("userLogin");
            if (user != null) {
                MongoDBConnector connector = new MongoDBConnector();
                LocalDate now = LocalDate.now();
                String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String expdate = request.getParameter("expdate");

                String itemName = request.getParameter("itemName");
                if (itemName == null) {

        %>

        <h1><p>Auction a Product</p></h1>
        <!--If user is logged in then -->
        <form method="post"action="Auction.jsp" id = "auctionform">
            <table>
                <tr>
                    <td>
                        <p>Name:</p>
                    </td>
                    <td>
                        <input type="text" name="itemName">
                    </td>
                </tr>

                <tr>
                    <td>
                        <p>Category:</p>
                    </td>
                    <td>
                        <select name="itemC" required>
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
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Description:</p>
                    </td>
                    <td>
                        <input type="text" name="itemDesc">
                    </td>
                </tr>

                <tr>
                    <td>
                        <p>Quantity:</p>
                    </td>
                    <td>
                        <input type="text" name="itemQ">
                    </td>
                </tr>                
                <tr>
                    <td>
                        <p>Lowest price:</p>
                    </td>
                    <td>
                        <input type="text" name="itemPrice">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Image (URL only):</p>
                    </td>
                    <td>
                        <input id="" type="text" placeholder="https://..." name="img" required>
                    </td>
                </tr>


                <tr>
                    <td>
                        <p>Expire Date:</p>
                    </td>
                    <td>
                        <input type="date" name="expdate" id="expdate">
                    </td>
                </tr>
                <tr><td></td><td>
                        <!--If all necessary forms are filled out then let user submit -->
                        <input type="submit" value="Auction item">
                    </td></tr>
            </table>
        </form>
        <%        } else if (expdate.compareTo(date) < 0) {
        %>
        <p><%=itemName%>  Has a wrong time</p>
        <a href="Auction.jsp">Auction again</a>
        <%
        } else {

            String itemCategory = request.getParameter("itemC");
            String itemDesc = request.getParameter("itemDesc");

            Double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            String itemDateListed = "" + java.time.LocalDate.now();
            int itemQuantity = Integer.parseInt(request.getParameter("itemQ"));
            String expdate1 = request.getParameter("expdate");

            String itemSellerID = user.getID();
            Random rand = new Random();
            String itemID = "" + rand.nextInt(999999999);
            boolean ifAuc = true;
            String img = request.getParameter("img");

            connector.addAucItem(itemID, itemName, itemDateListed, itemQuantity, itemPrice, itemDesc, itemCategory, itemSellerID, expdate1, img, ifAuc);
        %>
        <p><%=itemName%> has been Auctioned</p>
        <a href="Auction.jsp">Auction another Product</a>
        <a href="./">home</a>

        <%
            }

        } else {
        %>
        <p>You must be logged in to list an item</p>
        <p>Log in <a href="login.jsp">here</a></p>
        <p>Register a new account <a href="register.jsp">here</a></p>
        <%
            }        
        %>

    </body>
</html>