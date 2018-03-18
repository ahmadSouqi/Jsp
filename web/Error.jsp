<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/18/18
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
      <h3 align="left">
            Error Message:  <%=exception.toString()%>
      </h3>
</body>
</html>
