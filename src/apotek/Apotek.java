/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;
import java.sql.SQLException;
import model.model_login;

/**
 *
 * @author JUNITA
 */
public class Apotek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SQLException {
                viewKasir.login loginn =new viewKasir.login();
                model.model_login modell = new model_login();
                control.user controll = new control.user(loginn,modell);
                
    }
    
}