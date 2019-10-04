<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
        
    </head>

    <body>        
        <%  // Grabs data from the controller
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("itemList");
            String error = (String) request.getAttribute("error");
            String searched = (String) request.getAttribute("searched");
        %>
        
        <jsp:include page="../header.jsp"/>
        <div class="container">
            <div class="row">
                <h> All products </h>
            </div>
            <!--Displays the search options available to the user-->
            <div class="row">
                <form action="./home">
                    Search Bar
                    <input type="text" name="searchText">
                    <input type="submit" name="search" value="Search">
                    <br>
                    <input type="radio" name="searchType" value="item" checked> Search for Item </input>
                    <input type="radio" name="searchType" value="category"> Search for Category </input>
                    <br>
                    <select name="sort">
                        <option value="null"> Sort By </option>
                        <option value="lowToHigh"> Price - Low to High </option>
                        <option value="highToLow"> Price - High to low </option>
                    </select>       
                </form>
            </div>
            <div class="row">
                <!-- Error check-->
                <% if(!error.equals("")){ %>
                        <%=error%>
                    <% } else {%>
                    <% if(!searched.equals((""))) { %>
                        <div class="row">
                        <p> Searched for:</p>
                        <h1><%=searched%></h1>
                        <div class="vl"></div>
                    <% }} %>
            </div> 
            <!--Each item is displayed as a card-->
            <div class="row">
                <div class="itemList">
                    <%for (int i = 0; i < items.size(); i++) { Item item = items.get(i);%>
                    <a href="./item?id=<%=item.getID()%>" id="<%=item.getID()%>" class="itemCard">
                        <div class="imageContainer">
                            <span class="helper"></span>
                            <img src="<%=item.getImage()%>"/>
                        </div>
                        <br>
                         <%=item.getName()%>
                         $<%=item.getPrice()%>
                    </a>
                    <% } %>
                </div>        
            </div>
            </div> 
        </div>
    </body>
    
</html>