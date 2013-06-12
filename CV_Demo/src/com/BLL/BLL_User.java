package com.BLL;

import com.DAL.DAL_User;

/**
 * @author Miguel Rdz
 * @since 12/5/2013
 * @version 1.0
 */
public class BLL_User {

    /**
     * Verifica la existencia de un usuario llamando su método en la capa de datos (DAL).
     *
     * @param user El nombre de usuario.
     * @param´password La contraseña del usuario.
     * @return true si existe, de lo contrario false.
     */
    public boolean autenticateUser(String user, String password) {
        DAL_User usr = new DAL_User();
        if (usr.autenticateUser(user, password)) {
            return true;
        } else {
            return false;
        }
    }
}
