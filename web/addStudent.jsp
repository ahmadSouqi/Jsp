<%@ page import="com.model.StudentDAO" %><%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/18/18
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <jsp:useBean id="student" class="com.model.Student">
        <jsp:setProperty name="student" property="*" />
    </jsp:useBean>
    <%
        StudentDAO dao=new StudentDAO(application.getInitParameter("DB_Url"),
                application.getInitParameter("DB_UserName"),
                application.getInitParameter("DB_Password"));
        dao.addStudent(student);
    %>
    <jsp:forward page="getStudents.jsp"/>
</body>
</html>
