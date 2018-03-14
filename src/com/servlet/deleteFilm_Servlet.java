package com.servlet;

import com.model.FilmDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 3/14/18.
 */
@WebServlet(name = "deleteFilm_Servlet", urlPatterns = "/deleteFilm_Servlet.do")
public class deleteFilm_Servlet extends HttpServlet {

    private FilmDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new FilmDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long film_id=Long.parseLong(request.getParameter("film_id"));

        dao.deleteFilm(film_id);
        request.getRequestDispatcher("/getFilms_Servlet.do").forward(request,response);
    }
}
