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
import model.model_kasir;
import model.model_login;
import model.model_pemilik;
import viewKasir.menu;

/**
 *
 * @author JUNITA
 */
public class ckasir {

    private menu menuu;
    private model_kasir modell;
    String username;
    private int kodeobat;
    private String namaobat;
    private int satuan;
    private int isi;
    private int stok;
    private int hargabeli;
    private int hargasatuan;
    private int hargabox;

    public ckasir(model_kasir modell, menu menuu) throws SQLException {
        this.menuu = menuu;
        this.modell = modell;

        menuu.setVisible(true);
        menuu.showCard("dataObat");
        //data obat
        //obat umum
        menuu.setTabel(modell.getTableObatUmum());
        menuu.tabelListener(new getTabelObatUmum());
        menuu.obatListener(new obatListener());
        menuu.SearchObatUmum(new SearchObatUmum());
        menuu.kembaliListener(new kembaliListener());

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
    
        private class obatListener implements ActionListener {

        public obatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("dataObat");
        }
    }
        
        private class SearchObatUmum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                menuu.setTabel(modell.getTableObatUmumCari("'" + menuu.gettxtsearch1() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel(modell.getTableObatUmum());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
