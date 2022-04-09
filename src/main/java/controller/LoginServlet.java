package controller;

import dao.UserDao;
import model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            userDao = new UserDao();

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (!userDao.isExistUsername(username)) {
                System.out.println("This username has not already exist!");
                request.getServletContext().getRequestDispatcher("/signin").forward(request, response);
            } else if (userDao.isValid(username, password)) {
                HttpSession session = request.getSession(true);
                Users user = userDao.getUser(username);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("firstname", user.getFirstname());
                session.setAttribute("lastname", user.getLastname());
                session.setAttribute("role", user.getRole());
                System.out.println(session.getId());
                request.getServletContext().getRequestDispatcher("/info").forward(request, response);
            } else {
                System.out.println("Wrong password!");
                request.getServletContext().getRequestDispatcher("/login").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
