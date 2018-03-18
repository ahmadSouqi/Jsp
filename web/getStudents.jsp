<%@ page import="com.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.StudentDAO" %><%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/15/18
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>
</head>
<body>
 <table border=2>
 <tr>
     <th>Student ID</th>
     <th>First Name</th>
     <th>Last Name</th>
     <th>Average</th>
     <th>University</th>
     <th>Evolution</th>
 </tr>

  <%
      StudentDAO dao=new StudentDAO(application.getInitParameter("DB_Url"),
              application.getInitParameter("DB_UserName"),
              application.getInitParameter("DB_Password"));

        List<Student> students = dao.getStudents();
        for (Student student : students) { %>
            <tr>
               <td><%=student.getId()%></td>
                <td><%=student.getFirstName()%></td>
                <td><%=student.getLastName()%></td>
                <td><%=student.getAverage()%></td>
                <td><%=student.getUniversity()%></td>
                <td><%=student.getEvolution()%></td>
            </tr>
     <% } %>
</table>
</body>
</html>
