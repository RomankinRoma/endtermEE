package kz.iitu.endtermEE.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123456";

        try
        {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Printing connection object "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
