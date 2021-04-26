package kz.iitu.endtermEE.servlets;

import kz.iitu.endtermEE.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            UserDao userDao=new UserDao();
            String n=request.getParameter("username");
            String p=request.getParameter("password");
            if(UserDao.validate(n, p))
            {
                Cookie loginCookie = new Cookie("username", n);
                HttpSession session = request.getSession();
                session.setAttribute("username",n);
                session.setMaxInactiveInterval(60*60);
                loginCookie.setMaxAge(60*60);
                response.addCookie(loginCookie);
                RequestDispatcher rd=request.getRequestDispatcher("/Posts.jsp");
                rd.forward(request,response);
            }
            else
            {
                out.print("Sorry username or password error");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
