package com.util;

/**
 *
 * @author Miguel Rdz (nkasee)
 */
import java.sql.*;

public class Connector {

    private static String db = "db";
    private static String user = "root";
    private static String password = "1234";
    private static String url = "jdbc:mysql://localhost:3306/" + db;
    private static String driverName = "com.mysql.jdbc.Driver";
    private static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                conn = DriverManager.getConnection(url, user, password);
                if (conn != null) {
                    System.out.println("Database Connection " + url + " ... Ok");
                }
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return conn;
    }
}
