package com.lanou3g.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter",urlPatterns = {"/user","/index.jsp"})
public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object username = request.getSession().getAttribute("username");
        if (username !=null) {
            chain.doFilter(req, resp);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
