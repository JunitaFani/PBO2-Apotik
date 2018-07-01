/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_kasir;
import viewKasir.menu;

/**
 *
 * @author JUNITA
 */
public class ckasir_menu {
        
    private menu menuu;
    private model_kasir modell;

    public ckasir_menu(model_kasir modell, menu menuuu) {
        this.menuu = menuuu;

        menuuu.setVisible(true);
        menuuu.showCard("mainMenu");

        menuu.obatListener(new obatListener());
        menuu.kasListener(new dataKasListener());
        menuu.pelangganListener(new pelangganListener());
        menuu.tagihanListener(new tagihanListener());
        
    }

    private class obatListener implements ActionListener {

        public obatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_kasir();
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckasir_obat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class dataKasListener implements ActionListener {

        public dataKasListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_kasir();
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckasir_datakas(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       public class tagihanListener implements ActionListener {

        public tagihanListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_kasir();
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckasir_tagihan(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       
              public class pelangganListener implements ActionListener {

        public pelangganListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_kasir();
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckasir_pelanggan(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
