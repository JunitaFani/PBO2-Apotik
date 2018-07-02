/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import control.user;
import java.sql.SQLException;
import model.model_login;
import view.login;

/**
 *
 * @author JUNITA
 */
public class Apotek {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
//        new user(new login(), new model_login());
        view.login login = new login();
        model.model_login model = new model_login();
        new control.user(login, model);

    }

}
