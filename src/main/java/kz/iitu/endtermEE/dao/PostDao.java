package kz.iitu.endtermEE.dao;

import kz.iitu.endtermEE.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    public PostDao() throws SQLException {
    }

    public Post getById(int id) throws SQLException {
        Connection con = DBConnection.createConnection();
        String query = "select * from post where post.id=" + id;
        System.out.println(query);
        PreparedStatement preparedStatement = con.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        Post post = new Post();
        if (rs.next()) {
            post.setId(rs.getInt("id"));
            post.setHead(rs.getString("head"));
            post.setInfo(rs.getString("info"));
            post.setUser_id(rs.getInt("user_id"));
        }
        return post;
    }

    public String createPost(Post post, String username) {
        String head = post.getHead();
        ;
        String info = post.getInfo();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            UserDao userDao = new UserDao();
            int id = userDao.getByUsername(username).getId();
            con = DBConnection.createConnection();
            String query = "insert into post(head,info,user_id) values (?,?,?) RETURNING id";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(3, id);
            preparedStatement.setString(2, info);
            preparedStatement.setString(1, head);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return String.valueOf(resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "!SUCCESS";
    }

    public List<Post> getAll() throws SQLException {
        Connection con = DBConnection.createConnection();
        String query = "select * from post";
        System.out.println(query);
        PreparedStatement preparedStatement = con.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        List<Post> posts = new ArrayList<>();
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setHead(rs.getString("head"));
            post.setInfo(rs.getString("info"));
            posts.add(post);
        }
        return posts;
    }

    public boolean delete(int id) throws SQLException {
        Connection con = DBConnection.createConnection();
        String query = "delete from post where post.id=" + id;
        PreparedStatement preparedStatement = con.prepareStatement(query);

        int i = preparedStatement.executeUpdate();
        if (i != 0)
            return true;
        return false;
    }
    public Post update(Post post) throws SQLException {
        Connection con = DBConnection.createConnection();
        String query = "update post set head=?,info=? where id =?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(3,post.getId());
        preparedStatement.setString(1,post.getHead());
        preparedStatement.setString(2,post.getInfo());
        System.out.println(query);
        preparedStatement.executeUpdate();
        return getById(post.getId());
    }
}

