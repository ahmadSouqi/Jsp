package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asouqi on 3/14/18.
 */
@WebFilter(filterName = "Filter", urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session=request.getSession();
        boolean isLogIn= session.getAttribute("user")!=null;
        boolean logInRequest=request.getRequestURI().equals("/log.do");

        if (isLogIn || logInRequest)
             chain.doFilter(request,response);
        else
            request.getRequestDispatcher("/log.do").forward(request,response);
    }

    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}
}
