/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.model_login;
import model.model_pemilik;
import viewPemilik.menu;

/**
 *
 * @author JUNITA
 */
public class cPemilik {
    private menu menuu;
    private model_pemilik modell;
    String username;
        public cPemilik(model_pemilik modell,menu menuu ) {
        this.menuu = menuu;
        this.modell = modell;
    }

    
}
