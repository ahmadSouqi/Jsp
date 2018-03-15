package com.servlet;

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
@WebServlet(name = "deleteStudent_Servlet", urlPatterns = "/deleteStudent_Servlet.do")
public class deleteStudent_Servlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new StudentDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long film_id=Long.parseLong(request.getParameter("student_id"));

        dao.deleteStudent(film_id);
        request.getRequestDispatcher("/getStudents_Servlet.do").forward(request,response);
    }
}
