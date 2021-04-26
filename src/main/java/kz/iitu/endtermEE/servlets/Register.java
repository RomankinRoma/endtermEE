package kz.iitu.endtermEE.servlets;

import kz.iitu.endtermEE.dao.UserDao;
import kz.iitu.endtermEE.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        try {
            UserDao userDao = new UserDao();
            String userRegistered = userDao.registerUser(user);

            if(userRegistered.equals("SUCCESS"))
            {

                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("errMessage", userRegistered);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
