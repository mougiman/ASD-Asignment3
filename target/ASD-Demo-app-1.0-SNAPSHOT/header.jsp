<%-- 
    Document   : header
    Created on : 15/08/2019, 5:55:03 PM
    Author     : Changkeun
--%>
<%@page import="asd.demo.model.User"%>
<%@page import="asd.demo.model.Users"%>
<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <header>      
        <title>Barter-Mart</title>
        <link rel="stylesheet" href="css/BetterASDStyle.css">
    </header>


    <div class="title">
        <div style="display: inline-block">
            <p style="size: 160px">Sell n' Buy</p>
        </div>
        <div class="searchbar">
            <form action="./home">
                <div class="">
                    <input type="text" name="searchText" style="width: 240px; height: 30px">
                    <input type="submit" name="search" value="Search" class="searchbutton">
                </div>
                <br>
                <input type="radio" name="searchType" value="item" style="size: 20px" checked > Search for Item </input>
                <input type="radio" name="searchType" value="category" style="size: 20px" > Search for Category </input>                
                <select name="sort"  style="color: black">
                    <option value="null"> Sort By </option>
                    <option value="lowToHigh"> Price - Low to High </option>
                    <option value="highToLow"> Price - High to low </option>
                </select>   
                <br>
            </form>
        </div>
    </div>
    <% User user = (User) session.getAttribute("userLogin"); %>                                 
    <div class ="navbar">
        <span class="leftalign">
            <% if (user != null) { %>
            <a href=".\" class="links">Home</a> <!--- Links back to index --->
            <a href="listItem.jsp" class="links">List an Item</a>
            <a href="Auction.jsp" class="links">Auction a Product</a>
            <a href=".\admin" class="links"> Administration </a>

            <% } else { %> 
            <a href=".\" class="links">Home</a> <!--- Links back to index --->
            <a href="listItem.jsp" class="links">List an Item</a>
            <a href="Auction.jsp" class="links">Auction a Product</a>

            <% } %>
        </span>
        <span class="rightalign">
            <% if (user != null) {
                    if (user.getIsAdmin()) {
            %>	
            <a href=".\admin?id=<%=user.getID()%>" class="links"> Administration </a>
            <% 
                }
            %>

            <a href="./profile?id=<%=user.getID()%>"> <%=user.getEmail()%>'s Profile</a>               
            <a href="cart.jsp">Cart</a>
            <a href="logout.jsp">Logout</a>
            <a href="./watchlist?id=<%=user.getID()%>">Watchlist</a>
            <% } else { %>                      
            <a href="login.jsp" class="links">Log In</a>
            <a href="register.jsp" class="links" >Register</a>
            <% }%>                    
        </span> 
    </div>
</html>
