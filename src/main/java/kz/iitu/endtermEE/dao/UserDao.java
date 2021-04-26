package kz.iitu.endtermEE.dao;

import kz.iitu.endtermEE.model.Post;
import kz.iitu.endtermEE.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public UserDao() throws SQLException {
    }

        public String registerUser(User user)
        {
            String username = user.getUsername();
            String password = user.getPassword();

            Connection con = null;
            PreparedStatement preparedStatement = null;
            try
            {
                con = DBConnection.createConnection();
                String query = "insert into users(username,password) values (?,?)";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                int i= preparedStatement.executeUpdate();

                if (i!=0)
                    return "SUCCESS";
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return "!SUCCESS";
        }
    public static boolean validate(String username,String password)
    {
        boolean status=false;
        try
        {
            Connection con=DBConnection.createConnection();

            PreparedStatement ps=con.prepareStatement(
                    "select * from users where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public User getByUsername(String username) throws SQLException {
        Connection con = DBConnection.createConnection();
        String query = "select * from users where users.username='"+username+"'";
        System.out.println(query);
        PreparedStatement preparedStatement = con.prepareStatement(query);

        ResultSet rs= preparedStatement.executeQuery();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
        }
        return user;
    }
}

