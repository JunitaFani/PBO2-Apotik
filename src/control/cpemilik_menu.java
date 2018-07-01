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
import viewPemilik.menu;

/**
 *
 * @author JUNITA
 */
public class cpemilik_menu {
    
    private menu menuu;
    private model_pemilik modell;

    public cpemilik_menu(model_pemilik modell, menu menuuu) {
        this.menuu = menuuu;

        menuuu.setVisible(true);
        menuuu.showCard("mainMenu");

        menuu.datapegawaiListener(new datapegawaiListener());
        menuu.datakasListener(new dataKasListener());
        menuu.laporanPelangganListener(new laporanPelangganListener());
        menuu.laporanObatListener(new laporanobatListener());
        
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
                new cpemilik_datakas(modell, menuu);
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
       
              public class laporanPelangganListener implements ActionListener {

        public laporanPelangganListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_pemilik();
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new cpemilik_laporanpelanggan(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
