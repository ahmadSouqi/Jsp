package com.servlet;

import com.model.User;
import com.model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Created by asouqi on 3/14/18.
 */
@WebServlet(name = "Login_Servlet", urlPatterns ={"/log.do"})
public class Login_Servlet extends HttpServlet {

    private UserDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new UserDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name=request.getParameter("txtUserName");
         String password=request.getParameter("txtPassword");
         User user=new User(name,password);

         if (isValid(user)){
             HttpSession session=request.getSession();
             session.setAttribute("user",user);
             request.getRequestDispatcher("CrudForm.jsp").forward(request,response);
         }
         else
             request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");

        if (isValid(user))
           request.getRequestDispatcher("CrudForm.jsp").forward(request,response);
        else
            request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private boolean isValid(User user) {
        Set<User> users=dao.getUsers();

        if (user!=null && users.contains(user)){
            return true;
        }
        else
            return false;
    }
}
