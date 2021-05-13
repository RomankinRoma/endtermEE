package kz.iitu.endtermEE.servlets;

import kz.iitu.endtermEE.dao.PostDao;
import kz.iitu.endtermEE.model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Comment", value = "/comment")
public class Comments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentT = request.getParameter("comment");
        String username = request.getParameter("username");
        int postId = Integer.parseInt(request.getParameter("id"));

        Comment commentM = new Comment();
        commentM.setComment(commentT);
        commentM.setUsername(username);

        try {
            HttpSession session=request.getSession();
            PostDao postDao = new PostDao();
            String id = postDao.create(commentM, Integer.parseInt(request.getParameter("id")));
            if(!id.equals("!SUCCESS"))
            {
                request.setAttribute("post",postDao.getById(Integer.parseInt(request.getParameter("id"))));
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
