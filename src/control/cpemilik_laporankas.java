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

/**
 *
 * @author JUNITA
 */
public class cpemilik_laporankas extends cpemilik_menu {

    private menu_pemilik menuu;
    private model_pemilik modell;

    public cpemilik_laporankas(model_pemilik modell, menu_pemilik menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;
        menuu.showCard("laporankas");
        menuu.setTabel4(modell.getTableModelLaporan());
        menuu.kembaliMenu4().addActionListener(new kembaliMenu());
        menuu.cari1listener(new btnCari());
        menuu.segarkan2Listener(new segarkanListener());
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cpemilik_menu(modell, menuu);
        }

    }

    private class btnCari implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel4(modell.getTableModelcarilaporan("'" + menuu.GetTanggal1() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_laporankas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel4(modell.getTableModelLaporan());
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_laporankas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
