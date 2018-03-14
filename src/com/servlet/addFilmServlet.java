package com.servlet;

import com.model.Film;
import com.model.FilmDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asouqi on 3/13/18.
 */
@WebServlet(name = "addFilmServlet", urlPatterns ="/addFilmServlet.do")
public class addFilmServlet extends HttpServlet {

    private FilmDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new FilmDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id=Long.parseLong(request.getParameter("id"));
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        int    release_year=Integer.parseInt(request.getParameter("release_year"));

        Film film=new Film(id,title,description,release_year);

        dao.addFilm(film);

        response.sendRedirect("/getFilmsServlet.do");
    }
}
