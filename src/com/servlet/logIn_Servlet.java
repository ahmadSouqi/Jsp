package com.servlet;

import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asouqi on 3/14/18.
 */
@WebServlet(name = "logIn_Servlet", urlPatterns = "/log.do")
public class logIn_Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name=request.getParameter("txtUserName");
         String password=request.getParameter("txtPassword");
         User user=new User(name,password);

         if (isValid(user)){
             HttpSession session=request.getSession();
             session.setAttribute("user",user);
             request.getRequestDispatcher("CrudForm.html").forward(request,response);
         }
         else
             request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private boolean isValid(User user) {
        if (user!=null && user.getUserName().equals("Ali") && user.getPassword().equals("123")){
            return true;
        }
        else
            return false;
    }
}
