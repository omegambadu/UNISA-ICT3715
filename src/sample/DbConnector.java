package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {


    public static Connection getConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/67608566","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       System.out.println("database connected");
        return connection;

    }


}

