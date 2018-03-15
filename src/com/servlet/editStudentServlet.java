package com.servlet;

import com.model.Student;
import com.model.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 3/14/18.
 */
@WebServlet(name = "editStudentServlet", urlPatterns = "/editStudentServlet.do")
public class editStudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new StudentDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        double    average=Double.parseDouble(request.getParameter("average"));
        String university=request.getParameter("university");

        Student student =new Student(id,firstName,lastName,average,university);

        dao.editStudent(student);

        response.sendRedirect("/getStudents_Servlet.do");
    }
}
