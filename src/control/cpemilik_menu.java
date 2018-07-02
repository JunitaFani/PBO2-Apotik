/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import model.model_pemilik;
import view.menu_pemilik;

/**
 *
 * @author JUNITA
 */
public class cpemilik_menu {

    private menu_pemilik menuu;
    private model_pemilik modell;
    user login;

    public cpemilik_menu(model_pemilik modell, menu_pemilik menuuu) {
        this.menuu = menuuu;

        menuuu.setVisible(true);
        menuuu.showCard("mainMenu");

        menuu.datapegawaiListener(new datapegawaiListener());
        menuu.datakasListener(new dataKasListener());
        menuu.laporanObatListener(new laporanobatListener());
        menuu.setsessionnama(login.getUserLogin());
        menuu.setsessionkode(login.getIdLogin());

    }

    private class datapegawaiListener implements ActionListener {

        public datapegawaiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_pemilik();
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new cpemilik_pegawai(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class dataKasListener implements ActionListener {

        public dataKasListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_pemilik();
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new cpemilik_laporankas(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class laporanobatListener implements ActionListener {

        public laporanobatListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_pemilik();
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new cpemilik_laporanobat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
