package kz.iitu.endtermEE.servlets;

import kz.iitu.endtermEE.dao.PostDao;
import kz.iitu.endtermEE.model.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DeletePost", value = "/delete/*")
public class DeletePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session= request.getSession();
            Post post = (Post) session.getAttribute("post");
            PrintWriter out = response.getWriter();
            PostDao postDao = new PostDao();
            if (postDao.delete(post.getId()))
                request.getRequestDispatcher("/Posts.jsp").forward(request, response);
            else {
                out.println("Something went wrong!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
