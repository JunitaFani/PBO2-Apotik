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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_karyawan;
import viewKaryawan.menu;

/**
 *
 * @author JUNITA
 */
public class ckaryawan_laporanpelanggan extends ckaryawan_menu{
     private menu menuu;
    private model_karyawan modell;
    private String tgldaftar;
    private int kodepelanggan;
    private int jeniskelamin;
    private String namapelanggan;
    private String tgllahir;
    private String alamat;
    private String notelpon;

    public ckaryawan_laporanpelanggan(model_karyawan modell, menu menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;
        menuu.showCard("laporanPelanggan");
//        menuu.setTabelpelanggan(modell.getTablepelanggan());
//        menuu.tabelpelanggan(new tabelpelanggan());
        menuu.kembaliMenu4().addActionListener(new kembaliMenu());
//        menuu.SearchObatUmum(new SearchPelanggan());
//        menuu.segarkanListener(new segarkanListener());
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckaryawan_menu(modell, menuu);
        }

    }

    private class tabelpelanggan implements MouseListener {

        public tabelpelanggan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel model = (DefaultTableModel) menuu.gettabelpelanggan().getModel();
            menuu.gettabelpelanggan().setEnabled(false);
            kodepelanggan = Integer.parseInt(model.getValueAt(menuu.getBaristabelpelanggan(), 0).toString());
            tgldaftar = model.getValueAt(menuu.getBaristabelpelanggan(), 1).toString();
            namapelanggan = model.getValueAt(menuu.getBaristabelpelanggan(), 2).toString();
            String getjeniskelamin = model.getValueAt(menuu.getBaristabelpelanggan(), 3).toString();
            tgllahir = model.getValueAt(menuu.getBaristabelpelanggan(), 4).toString();
            alamat = model.getValueAt(menuu.getBaristabelpelanggan(), 5).toString();
            notelpon = model.getValueAt(menuu.getBaristabelpelanggan(), 6).toString();

            System.out.println("getTabelPegawai" + kodepelanggan);

            menuu.gettabelpelanggan().setEnabled(false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class SearchPelanggan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                menuu.setTabelpelanggan(modell.getTablepelanggancari("'" + menuu.gettxtsearch() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanpelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabelpelanggan(modell.getTablepelanggan());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanpelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
