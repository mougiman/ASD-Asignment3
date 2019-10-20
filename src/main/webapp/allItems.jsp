<%-- 
    Document   : allListings
    Created on : 26/08/2019, 5:39:22 PM
    Author     : Calvin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
            <link rel="stylesheet" href="css/BetterASDStyle.css">
    </head>
    
    <body>
        <jsp:include page="header.jsp"/>
        <% 
            //Loading content from servlet 
            ArrayList <Item> itemList = (ArrayList<Item>) request.getAttribute("Items");
            String msg = (String) request.getAttribute("msg");
            String id = (String) request.getAttribute("id");
        %>
        
        <div class="container">
            <div class="row">
                <h>All Items</h>
            </div>
            <div class="row">
                <!-- <a href="addItem.jsp" value="add"> Add Item</a> -->
                <!-- Shows validation messages -->
                <div class="message">
                    <% if(msg != null){ %>
                        <u><b><%=msg%></b></u>  
                    <%  }  %>
                </div>
            </div>
            <div class="row">
                <table>
                    <!-- Table header -->
                    <tr>
                       <th> ID</th>
                       <th> Name </th>
                       <th> Date Listed</th>
                       <th> Stock </th>
                       <th> Price/Current Bid </th>
                       <th> Description </th>
                       <th> Category </th>
                       <th> Listing Expiry </th>
                       <th> Seller ID </th>
                       <th> Auctioned? </th>
                       <th> Image URL </th>
                       <th> Delete </th>
                       
                    </tr>
                    
                    <!-- Rows of items in a table -->
                    <% for(int i = 0; i < itemList.size();i++){Item item = itemList.get(i);%>
                        <tr>
                            <td>
                                <%=item.getID()%>
                            </td>
                            <td>
                                <%=item.getName()%>
                            </td>
                            <!-- Checks for delete confirmation -->
                            <% if(item.getID().equals(id)){%>
                            <td colspan="5">
                                Are you sure you want to delete this item?
                                <a href="./deleteItem?id=<%=id%>&confirm=true" name="yes"> Yes </a>
                                    &nbsp;&nbsp;&nbsp;
                                <a href="./allItems"> No </a>
                            </td>
                            <%} else {%>
                            <td>
                                <%=item.getDateListed()%>
                            </td>
                            <td>
                                <%=item.getStock()%>
                            </td>
                            <td>
                                $<%=item.getPrice()%>
                            </td>
                            <td>
                                <%=item.getDescription()%>
                            </td>
                            <td>
                                <%=item.getCategory()%>
                            </td>
                            <td>
                                <%=item.getExpDate()%>
                            </td>
                            <td>
                                <%=item.getSellerID()%>
                            </td>
                            <td>
                                <%if(item.ifAuc()){ %>
                                    Yes
                                <%} else {%>
                                    No
                                <% } %>      
                            </td>
                            <td>
                                    <%=item.getImage()%>
                            </td>
                            <td>
                                <a href="./deleteItem?id=<%=item.getID()%>" name="deleteID<%=item.getID()%>"> Delete </a>
                            </td>
                            <% } %>
                        </tr>
                    <% } %>
                </table>
            </div>
            <div class="row" style="height:100px">  
            </div>
        </div>
    </body>
</html>
