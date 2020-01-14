package com.github.martaprzybylo.skillscollector.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (req.getServletPath().equals("/register") || req.getServletPath().equals("/login")){
            chain.doFilter(req,res);
        } else if (req.getServletPath().equals("/user/skills") && session.getAttribute("user")==null) {
            res.sendRedirect("/login");
        }else if (req.getServletPath().equals("/user/skills") && session.getAttribute("user")!=null) {
            chain.doFilter(req,res);
        }else {
            res.sendError(500);
        }

    }
}
