/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.model_karyawan;
import view.menu_karyawan;

/**
 *
 * @author JUNITA
 */
public class ckaryawan_laporanobat extends ckaryawan_menu {

    private menu_karyawan menuu;
    private model_karyawan modell;
    String username;

    public ckaryawan_laporanobat(model_karyawan modell, menu_karyawan menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;

        menuu.setVisible(true);
        menuu.showCard("laporanObat");
        menuu.setTabel1(modell.getTableModelLaporanobat());
        menuu.laporanObatListener(new laporanObatListener());
        menuu.carilistener1(new btnCari());
        menuu.kembaliMenu3().addActionListener(new kembaliMenu());
        menuu.segarkanlistener2(new segarkanListener());

    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckaryawan_menu(modell, menuu);
        }

    }

    private class btnCari implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel1(modell.getTableModelcarilaporanobat("'" + menuu.GetTanggal() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class laporanObatListener implements ActionListener {

        public laporanObatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                       try {
                modell = new model_karyawan();
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ckaryawan_laporanobat(modell, menuu);
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel1(modell.getTableModelLaporanobat());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
