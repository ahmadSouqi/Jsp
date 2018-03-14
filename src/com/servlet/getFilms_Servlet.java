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
import java.util.List;

/**
 * Created by asouqi on 3/13/18.
 */
public class getFilms_Servlet extends HttpServlet {
    private FilmDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao=new FilmDAO(getServletContext().getInitParameter("DB_Url"),
                getServletContext().getInitParameter("DB_UserName"),
                getServletContext().getInitParameter("DB_Password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        List<Film> films= dao.getFilms();

        writer.println("<table border=2> " +
                       " <tr> <th>film ID</th>" +
                       " <th>Title</th>" +
                        " <th>Description</th>" +
                        " <th>Release Year</th>"+
                       "</tr>");

        for (Film film:films){
            writer.printf("<tr> <td> %d </td>",film.getId());
            writer.printf("<td> %s </td>",film.getTitle());
            writer.printf("<td> %s </td>",film.getDescription());
            writer.printf("<td> %d </td> </tr>",film.getRelease_year());
        }

        writer.println("</table>");
    }
}
