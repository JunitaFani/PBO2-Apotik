/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_kasir;
import view.menu_kasir;

/**
 *
 * @author JUNITA
 */
public class ckasir_menu {

    private menu_kasir menuu;
    private model_kasir modell;
    user login;

    public ckasir_menu(model_kasir modell, menu_kasir menuuu) {
        this.menuu = menuuu;

        menuuu.setVisible(true);
        menuuu.showCard("mainMenu");

        menuu.obatListener(new obatListener());
        menuu.kasListener(new dataKasListener());
        menuu.tagihanListener(new tagihanListener());
        menuu.setsessionnama(login.getUserLogin());
        menuu.setsessionkode(login.getIdLogin());

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
                new ckasir_laporankas(modell, menuu);
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
            } catch (ParseException ex) {
                Logger.getLogger(ckasir_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
