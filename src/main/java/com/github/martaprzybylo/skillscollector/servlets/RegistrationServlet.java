package com.github.martaprzybylo.skillscollector.servlets;

import com.github.martaprzybylo.skillscollector.dao.UserDao;
import com.github.martaprzybylo.skillscollector.model.User;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao ;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory) getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String registerJsp = "/WEB-INF/views/register.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(registerJsp);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        if (userDao.isUsernameAvailable(username)){
            userDao.save(user);
            resp.sendRedirect("/login");
        } else {
            resp.getWriter().println("Zajęta nazwa użytkownika");
        }

    }
}
