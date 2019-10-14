<%-- 
    Document   : allListings
    Created on : 26/08/2019, 5:39:22 PM
    Author     : Calvi
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
        <% //Dummy data, will be replaced when database is fixed
            ArrayList <Item> itemList = new ArrayList<Item>();
            //itemList.add(new Item("01","Dog","01/01/1901",10,30,9.99,"","","","","","",""));
            //itemList.add(new Item("02","Cat","01/02/1901",40,50,19.99,"","","","","","",""));
        %>
        <div class="container">
            <div class="row">
                <h>All Items</h>
            </div>
            <div class="row">
                <table>
                    <tr>
                       <th> ID</th>
                       <th> Name </th>
                       <th> Date Listed</th>
                       <th> Stock </th>
                       <th> Price/Current Bid </th>
                       <th> Description </th>
                       <th> Category </th>
                       <th> Seller ID </th>                       
                       <th> Image URL </th>
                       
                    </tr>
                    <% for(Item item: itemList){ %>
                        <tr>
                            <td>
                                <%=item.getID()%>
                            </td>
                            <td>
                                <%=item.getName()%>
                            </td>
                            <td>
                                <%=item.getDateListed()%>
                            </td>
                            <td>
                                <%=item.getStock()%>
                            </td>
                            <td>
                                <%=item.getSoldQuantity()%>
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
                                <%=item.getYearMade()%>
                            </td>
                            <td>
                                <%=item.getSellerID()%>
                            </td>
                            <td>
                                <%=item.getCondition()%>
                            </td>
                            <td>
                                <%=item.getColor()%>
                            </td>
                            <td>
                                <%=item.getImage()%>
                            </td>
                        </tr>
                    <% }%>
                </table>
            </div>
        </div>
    </body>
</html>
