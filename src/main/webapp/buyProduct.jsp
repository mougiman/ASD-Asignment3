<%-- 
    Document   : buyProduct
    Created on : 23/09/2019, 12:52:15 AM
    Author     : lee
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%
                //Attributes recieved from itemServlet
                Item item = (Item) request.getAttribute("buy_product_item");
                String error = (String) request.getAttribute("err");

                MongoDBConnector connector = new MongoDBConnector();
                if (item != null) {
            %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy a product Page</title>
          <link rel="stylesheet" href="css/ASDStyle.css">
          <style>
              .submit-btn{
                  padding: 5px;
                    width: 100px;
                    height: 39px;
                    font-size: 21px;
                    cursor: pointer;
                    margin-top: 15px;
              }
          </style>
    </head>
    <body>
        <h1>Product review</h1>
        <jsp:include page="header.jsp"/>    
        <form method="post" action="buy">
            <div class="container">
                <h1>Product</h1>

                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label> name：</label><%=item.getName()%>
                        </div>
                        <div class="form-group">
                            <label>Image：</label>
                            <img src="<%=item.getImage()%>" style="width:500px; height:400px;"/>
                        </div>
                        <div class="form-group">
                            <label> desc：</label><%=item.getDescription()%>
                        </div>
                        <div class="form-group">
                            <label>categor：</label><%=item.getCategory()%>
                        </div>
                        <div class="form-group">
                            <label> price：</label>$<%=item.getPrice()%>
                        </div>
                        <div class="form-group">
                            <label> Expiration Date：</label><%=item.getExpDate()%>
                        </div>
                        <div class="form-group">
                            <label> Pay Type：</label>
                            <input type="radio" name="pay" value="1" checked>银行卡支付
                            <input type="radio" name="pay" value="2">PayPal支付
                        </div>
                        
                        <input class="btn btn-success pull-right" type="submit" value="Buy">
                    </div>
                </div>
            </div>
        </form>
 
                    
    <script>
       
    </script>
    </body>
</html>
