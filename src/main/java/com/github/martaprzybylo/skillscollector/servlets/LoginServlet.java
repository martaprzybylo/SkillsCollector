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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {

        userDao = new UserDao((SessionFactory) getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginJsp = "/WEB-INF/views/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(loginJsp);
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();

        List<User> allByUsernameAndPassword = userDao.getAllByUsernameAndPassword(username, password);


        if (allByUsernameAndPassword.isEmpty()){
            req.setAttribute("error", "W bazie nie występuje użytkownik o podanym loginie lub/i haśle");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        } else {
            req.getSession().invalidate();
            HttpSession session = req.getSession(true);
            user = allByUsernameAndPassword.get(0);
            session.setAttribute("user", user);
            resp.sendRedirect("/user/skills");
        }


    }
}
