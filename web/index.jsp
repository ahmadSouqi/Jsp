<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/13/18
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
           <form action="/log.do" method="post">
               User Name: <input type="text" name="txtUserName"/><br>
               PassWord:  <input type="text" name="txtPassword"/><br>
               <input  type="submit" value="LogIn" align="left"/><br>
           </form>
  </body>
</html>
