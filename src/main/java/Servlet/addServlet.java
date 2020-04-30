package Servlet;


import Service.UserService;
import User.User;
import exception.DBException;

<<<<<<< HEAD

=======
>>>>>>> 4a6a73886ab8147813e1c4493238f2b2226fbf4c
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/create")
=======
import java.sql.SQLException;

@WebServlet(urlPatterns = "/create", name = "addServlet")
>>>>>>> 4a6a73886ab8147813e1c4493238f2b2226fbf4c
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/create.jsp");
        dispatcher.forward(req, resp);

    }
<<<<<<< HEAD

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user1 = new User(name, login, password);

        UserService userService = new UserService();

        boolean result = false;
        try {
            result = userService.addUser(user1);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
=======
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

>>>>>>> 4a6a73886ab8147813e1c4493238f2b2226fbf4c
}
