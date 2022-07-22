package com.example.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection getConnection() {
        //Connecting Db server
        String url = "jdbc:mysql://localhost:3306/atm";
        String uName = "root";
        String uPassword = "root";

        Connection connection = null;

        //Code that verifies the url, uName, uPassword with MySql
        try {
            //Connects to Driver-manager which calls the DB
            connection = DriverManager.getConnection(url, uName, uPassword);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
