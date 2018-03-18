<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/18/18
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD Operation</title>
</head>
<body>

      <a href="/getStudents.jsp">Get All Students</a>

      <div id="add">
          <form action="/addStudent.jsp" method="post">
              <strong>Add Student</strong>
              <jsp:include page="form.jsp"/>

          </form>
      </div>
      <br><br>

      <div id="edit">
          <strong>Edit Student</strong>
          <form action="/editStudent.jsp" method="post">
              <jsp:include page="form.jsp"/>
          </form>
      </div>
      <br><br>

      <div id="delete">
          <strong>Delete Student</strong>
          <form action="/deleteStudent_Servlet.do" method="get">
              <table>
                  <tr>
                      <td> Student ID:<input type="text" name="student_id"/></td>
                  </tr>
                  <tr>
                      <td align="right"><input type="submit"/></td>
                  </tr>
              </table>
          </form>
      </div>
      <br><br>

</body>
</html>
