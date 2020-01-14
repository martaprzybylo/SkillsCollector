package com.github.martaprzybylo.skillscollector.servlets;

import com.github.martaprzybylo.skillscollector.dao.UserDao;
import com.github.martaprzybylo.skillscollector.model.Skill;
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

@WebServlet (urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory) getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Skill> userSkills = null;
        User user = (User) req.getSession().getAttribute("user");
        userSkills = userDao.getAllUserSkills(user);
        req.setAttribute("userSkills", userSkills);


        String userSkillJsp = "/WEB-INF/views/user-skills.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(userSkillJsp);
        dispatcher.forward(req,resp);

    }
}
