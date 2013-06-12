package com.DAL;

import com.util.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Miguel Rdz
 * @since 12/5/2013
 * @version 1.0
 */
public class DAL_User {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
     * Consulta en la base de datos la existencia de un usuario.
     *
     * @param user El nombre de usuario.
     * @param´password La contraseña del usuario.
     * @return true si existe, de lo contrario false.
     * @throws SQLException si no hay acceso a la base de datos.
     */
    public boolean autenticateUser(String user, String password) {
        try {
            conn = Connector.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user WHERE User='"+user+"' AND Password='"+password+"'");
            if (rs.next()) {
                rs.close();
                stmt.close();
                conn.close();
                return true;
                
            } else {
                rs.close();
                stmt.close();
                conn.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
