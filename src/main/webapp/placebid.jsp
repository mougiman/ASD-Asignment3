<%-- 
    Document   : placebid
    Created on : 2019-8-14, 18:47:01
    Author     : Cai weize
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <jsp:include page="header.jsp"/>
    <body>



        <h1><p>Auction a Product</p></h1>
        <!--If user is logged in then -->
        <form method="post" action="placebid.jsp">
            <table>
                <tr>
                    <td>
                        <p>Proudct ID:</p>
                    </td>
                    <td>
                        <input type="text" name="PID"> <!--<input type="submit" value = "search"> -->

                    </td>
                </tr>

                <tr>
                    <td>
                        <p>Bid price:</p>
                    </td>
                    <td>
                        <input type="text" name="BP">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Customer ID:</p>
                    </td>
                    <td>
                        <input type="text" name="CID">
                    </td>
                </tr>
                <tr><td></td><td>
                        <!--If all necessary forms are filled out then let user submit -->
                        <input type="submit" value="Auction item">

                    </td></tr>
            </table>
        </form>
</html>
