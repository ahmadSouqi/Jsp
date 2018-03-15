package com.servlet;

import com.model.Student;
import com.model.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by asouqi on 3/13/18.
 */
public class getStudents_Servlet extends HttpServlet {
    private StudentDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new StudentDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        List<Student> students = dao.getStudents();

        writer.println("<table border=2> " +
                       " <tr> <th>Student ID</th>" +
                       " <th>First Name</th>" +
                        " <th>Last Name</th>" +
                        " <th>Average</th>"+
                        " <th>University</th>"+
                       "</tr>");

        for (Student student : students){
            writer.printf("<tr> <td> %d </td>", student.getId());
            writer.printf("<td> %s </td>", student.getFirst_name());
            writer.printf("<td> %s </td>", student.getLast_name());
            writer.printf("<td> %.2f </td>", student.getAvrg());
            writer.printf("<td> %s </td> </tr>", student.getUnvirsty());
        }

        writer.println("</table>");
    }
}
