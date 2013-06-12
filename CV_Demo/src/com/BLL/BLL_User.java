package com.BLL;

import com.DAL.DAL_User;

/**
 *
 * @author Miguel Rdz
 */
public class BLL_User {

    public boolean autenticateUser(String user, String password) {
        DAL_User usr = new DAL_User();
        if (usr.autenticateUser(user, password)) {
            return true;
        } else {
            return false;
        }
    }
}
