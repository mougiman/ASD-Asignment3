<%-- 
    Document   : Register
    Created on : 16/08/2019, 15:30:43 AM
    Author     : Chenkun
--%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.Random"%>
<%@page import="asd.demo.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <!--CSS -->
        <style type="text/css"> 
            body{
                background-image: url(css/1.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }
            .container{
	        margin-top: 90px;
                max-width: 400px;
                border-radius: 20px;
                margin:auto;
                background:rgba(0,0,0,0.8);
                padding: 40px;
                color: #fff;
                box-sizing: border-box;
            }
            .container h1{
                text-align: center;
            }
            
            .container label{
                width: 400px;
            }
            
            .container label.error{
                color:red;
            }
            
            .container input{
                display: block;
                width:100%;
                box-sizing: border-box;
                padding: 12px 5px;
                background: rgba(0,0,0,0.10);
                outline: none;
                border: none;
                border-bottom: 1px dotted #fff;
                color: #fff;
                border-radius: 5px;
                margin: 5px;
            }
            .container input[type="submit"]{
                width: 100%;
                box-sizing: border-box;
                padding: 10px 0;
                outline:none;
                border: none;
                opacity: 0.7;
                font-size: 20px;
                cursor: pointer;
                background: rgb(66,133,244);
                color:#fff;
            }
            
            .container input[type="button"]{
                width: 100%;
                box-sizing: border-box;
                padding: 10px 0;
                outline:none;
                border: none;
                opacity: 0.7;
                font-size: 20px;
                cursor: pointer;
                background: red;
                color:#fff;
            }
            
            .container input[type ="submit"]:hover{
                background: rgb(111,222,111);
            }
            
            .container input[type ="button"]:hover{
                background: gray;
            }
            
                       
        </style>
        <!--Form validation -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"</script>
        <script type=text/javascript></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js" type="text/javascript"></script>      
        <script>
           $(document).ready(function(){
                $('#registerform').validate({
                    rules:{
                        username:{
                            required: true,
                            textonly: true,
                            maxlength: 20,
                            uppercase: true
                        },
                       email:{
                            required: true,
                            email: true
                        },
                       password:{
                            required:true,
                            maxlength: 20,
                            minlength: 6
                       },
                       password2:{
                           required:true,
                           equalTo:"#pass"
                       },
                       phone:{
                           required: true,
                           digits: true,
                           minlength: 10 
                       }
                }
       
                });
                jQuery.validator.addMethod("textonly", function(value, element) {
                    return this.optional( element ) || /^[A-Za-z\s]+$/.test( value ); <!--Username should contain only text -->
                }, 'Please enter a valid name.');
                
                 jQuery.validator.addMethod("uppercase", function(value, element) {
                    return this.optional( element ) || /^[A-Z]/.test( value );       //Username should start with uppercase character
                }, 'Username should start with uppercase character.');
            }); 
         
        </script> 
    <body>
                <jsp:include page="header.jsp"/>
        <div class="container">
            <h1>REGISTER</h1>
            <form id="registerform"  action="reg-login" method="post">  
                <div>
                    <label>
                        Username
                    </label>
                    <input type="text" id="name" name="username">
                </div>
                <div>
                    <label>
                        Email
                    </label>
                    <input type="text" id="mail" name="email">
                </div>
                <div>
                    <label>
                        Password
                    </label>
                    <input type="password" id="pass" name="password">
                </div>
                <div>
                    <label>
                        Confirm Password
                    </label>
                    <input type="password" id="pass2" name="password2">
                </div>
                <div>
                    <label>
                        Mobile
                    </label>
                    <input type="text" id="num" name="phone">
                </div>
                <input type="submit" value="Register">
                <input type = "button" onclick="window.location.href='./'" value = "Cancel"/>
                </form>
            </div>
    </body>
</html>
