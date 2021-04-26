package kz.iitu.endtermEE.servlets;

import com.sun.glass.ui.View;
import kz.iitu.endtermEE.dao.PostDao;
import kz.iitu.endtermEE.dao.UserDao;
import kz.iitu.endtermEE.model.Post;
import kz.iitu.endtermEE.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Posts", value = "/post/*")
public class Posts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String contextPath = String.valueOf(request.getRequestURL()).split("/")[4];
            PrintWriter out = response.getWriter();
            PostDao postDao=new PostDao();
            Post post = postDao.getById(Integer.parseInt(contextPath));
            request.setAttribute("post",post);

            request.getRequestDispatcher("/PostInfo.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String head = request.getParameter("head");
        String info = request.getParameter("info");

        Post post = new Post();
        post.setInfo(info);
        post.setHead(head);

        try {
            HttpSession session=request.getSession();
            PostDao postDao = new PostDao();
            String id = postDao.createPost(post, request.getParameter("username"));
            if(!id.equals("!SUCCESS"))
            {
                request.setAttribute("post",post);
                request.getRequestDispatcher("/PostInfo.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("errMessage", id);
                request.getRequestDispatcher("/Posts.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
