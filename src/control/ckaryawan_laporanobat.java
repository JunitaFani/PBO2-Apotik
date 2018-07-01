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
import viewKaryawan.menu;

/**
 *
 * @author JUNITA
 */
public class ckaryawan_laporanobat extends ckaryawan_menu {

    private menu menuu;
    private model_karyawan modell;
    String username;
    private int kodeobat;
    private String namaobat;
    private int satuan;
    private int isi;
    private int stok;
    private int hargabeli;
    private int hargasatuan;
    private int hargabox;

    public ckaryawan_laporanobat(model_karyawan modell, menu menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;

        menuu.setVisible(true);
        menuu.showCard("laporanObat");
        //data obat
        //obat umum
//        menuu.setTabel(modell.getTableObatUmum());
//        menuu.tabelListener(new getTabelObatUmum());
        menuu.laporanObatListener(new laporanObatListener());

        menuu.kembaliMenu3().addActionListener(new kembaliMenu());
//        menuu.SearchObatUmum(new SearchObatUmum());
//        menuu.segarkanListener(new kembaliListener());

    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckaryawan_menu(modell, menuu);
        }

    }

    private class getTabelObatUmum implements MouseListener {

        public getTabelObatUmum() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            DefaultTableModel model = (DefaultTableModel) menuu.getTabelObatUmum().getModel();
            menuu.getTabelObatUmum().setEnabled(false);
            kodeobat = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 0).toString());
            namaobat = model.getValueAt(menuu.getBarisObatUmum(), 1).toString();
            String getsatuan = model.getValueAt(menuu.getBarisObatUmum(), 2).toString();
            isi = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 3).toString());
            stok = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 4).toString());
            hargabeli = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 5).toString());
            hargasatuan = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 6).toString());
            hargabox = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 7).toString());

            System.out.println("getTabelObatUmum" + kodeobat);

            menuu.getTabelObatUmum().setEnabled(false);
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

    private class laporanObatListener implements ActionListener {

        public laporanObatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("laporanObat");
        }
    }

    private class SearchObatUmum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                menuu.setTabel(modell.getTableObatUmumCari("'" + menuu.gettxtsearch1() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel(modell.getTableObatUmum());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_laporanobat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
