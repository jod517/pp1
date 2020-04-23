package Servlet;


import Service.UserService;
import User.User;
import exception.DBException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/create", name = "addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/create.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameUser = req.getParameter("name");
        String loginUser = req.getParameter("login");
        String passwordUser = req.getParameter("password");

        UserService userService = new UserService();

        User newuser = new User(nameUser, loginUser, passwordUser);
        boolean result = false;
        try {
            result = UserService.addUser(newuser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
