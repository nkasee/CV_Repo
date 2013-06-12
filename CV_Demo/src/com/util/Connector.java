package com.util;

/**
 * @author Miguel Rdz
 * @since 12/5/2013
 * @version 1.0
 */
import java.sql.*;

public class Connector {

    private static final String db = "db";
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/" + db;
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static Connection conn;

    /**
     * Obtiene la conexion a la base de datos.
     *
     * @return conn La conexion activa a la base de datos.
     * @throws SQLException error en la conexion a la base de datos.
     * @throws ClassNotFoundException No se encuentra el driver JDBC.
     */
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
