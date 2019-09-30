<%-- 
    Document   : logout
    Created on : 2019-8-17, 2:42:58
    Author     : lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
 
    </head>
    <body>
                <jsp:include page="header.jsp"/>
       <%=session.getAttribute("userEmail")%><br/>
        
         <%
             response.setHeader("refresh","0;URL=./");
             session.invalidate();
             %>
    </body>
</html>
