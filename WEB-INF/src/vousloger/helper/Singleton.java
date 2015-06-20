package vousloger.helper;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jordanmarques on 20/06/15.
 */
public class Singleton {
    private static Connection connection;

    public static Connection getInstance()
    {
        if(connection==null)
        {
            try {
                String url="jdbc:mysql://localhost:8889/ProjetJ2E";
                String user="root";
                String password="root";
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = (Connection) DriverManager.getConnection(url, user, password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
