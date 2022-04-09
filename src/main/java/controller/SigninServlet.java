package controller;

import dao.UserDao;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SigninServlet", value = "/Signin")
public class SigninServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userDao = new UserDao();

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            if (userDao.isExistUsername(username)) {
                System.out.println("This username has already exist!");
                request.getServletContext().getRequestDispatcher("/login").forward(request, resp);
            } else {
                HttpSession session = request.getSession();

                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("role", role);
                session.setAttribute("firstname", firstname);
                session.setAttribute("lastname", lastname);

                userDao.saveUser(firstname, lastname, username, password, role);
                request.getServletContext().getRequestDispatcher("/info").forward(request, resp);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }



    }
}