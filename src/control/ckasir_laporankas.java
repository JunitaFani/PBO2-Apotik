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
import view.menu_kasir;

/**
 *
 * @author JUNITA
 */
public class ckasir_laporankas extends ckasir_menu {

    private menu_kasir menuu;
    private model_kasir modell;

    public ckasir_laporankas(model_kasir modell, menu_kasir menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;
        menuu.showCard("laporankas");
        menuu.setTabel1(modell.getTableModelLaporan());
        menuu.kembaliMenu5().addActionListener(new kembaliMenu());
        menuu.segarkan2Listener(new segarkanListener());
        menuu.carilistener(new btnCari());
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckasir_menu(modell, menuu);
        }

    }

    private class btnCari implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel1(modell.getTableModelcarilaporan("'" + menuu.GetTanggal() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_laporankas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel1(modell.getTableModelLaporan());
            } catch (SQLException ex) {
                Logger.getLogger(ckasir_laporankas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
