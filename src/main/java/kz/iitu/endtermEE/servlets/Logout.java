package kz.iitu.endtermEE.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("username",null);
        HttpSession session = request.getSession();
        session.setAttribute("username",null);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }

        session = request.getSession(false);
        System.out.println("User=" + session.getAttribute("username"));
        if (session != null) {
            session.invalidate();
            System.out.println("INVALIDATED");
        }

        response.sendRedirect("/Login.jsp");
    }
}

