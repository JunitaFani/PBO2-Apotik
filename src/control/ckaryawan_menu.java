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
import model.model_karyawan;
import viewKaryawan.menu;

/**
 *
 * @author JUNITA
 */
public class ckaryawan_menu {

    private menu menuu;
    private model_karyawan modell;

    public ckaryawan_menu(model_karyawan modell, menu menuuu) {
        this.menuu = menuuu;

        menuuu.setVisible(true);
        menuuu.showCard("mainMenu");

        menuu.obatListener(new obatListener());
        menuu.pelangganListener(new pelangganListener());
        menuu.laporanPelangganListener(new laporanPelangganListener());
        menuu.laporanObatListener(new laporanobatListener());
        
    }

    private class obatListener implements ActionListener {

        public obatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_karyawan();
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
//                new ckaryawan(modell, menuu);
                new ckaryawan_obat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class pelangganListener implements ActionListener {

        public pelangganListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_karyawan();
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckaryawan_pelanggan(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       public class laporanobatListener implements ActionListener {

        public laporanobatListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_karyawan();
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckaryawan_laporanobat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       
              public class laporanPelangganListener implements ActionListener {

        public laporanPelangganListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_karyawan();
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckaryawan_laporanpelanggan(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
