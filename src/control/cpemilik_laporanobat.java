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
import model.model_pemilik;
import view.menu_pemilik;
import control.ckaryawan_obat;
/**
 *
 * @author JUNITA
 */
public class cpemilik_laporanobat extends cpemilik_menu {

    private menu_pemilik menuu;
    private model_pemilik modell;
    String username;

    public cpemilik_laporanobat(model_pemilik modell, menu_pemilik menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;

        menuu.setVisible(true);
        menuu.showCard("laporanObat");
        menuu.setTabel3(modell.getTableModelLaporanobat());
        menuu.laporanObatListener(new laporanObatListener());
        menuu.carilistener(new btnCari());
        menuu.kembaliMenu3().addActionListener(new kembaliMenu());
        menuu.segarkanlistener(new segarkanListener());

    }
    String tanggal;
    public String GetTanggal() {
        return tanggal;
    }
    
    
    
    private class btnCari implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel3(modell.getTableModelcarilaporanobat("'" + menuu.GetTanggal() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cpemilik_menu(modell, menuu);
        }

    }
 
    private class laporanObatListener implements ActionListener {

        public laporanObatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modell = new model_pemilik();
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new cpemilik_laporanobat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel3(modell.getTableModelLaporan());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
