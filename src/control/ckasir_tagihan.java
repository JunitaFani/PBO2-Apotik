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
import model.model_kasir;
import viewKasir.menu;

/**
 *
 * @author JUNITA
 */
public class ckasir_tagihan {

    private menu menuu;
    private model_kasir modell;
    String username;
    private int koderesep;
    private String tgl;
    private int kodeitem;
    private int jumlah;
    private int kodepelanggan;

    public ckasir_tagihan(model_kasir modell, menu menuu) throws SQLException {
        this.menuu = menuu;
        this.modell = modell;
        menuu.setVisible(true);
        menuu.showCard("dataTagihan");
        menuu.kembaliMenu().addActionListener(new kembaliMenu());
        menuu.setTabeltagihan(modell.getTabletagihan());
        resettagihan();
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckasir_menu(modell, menuu);
        }

    }

    public void resettagihan() {
        menuu.settgl("");
        menuu.setkodeResep("");
        menuu.setPelanggan("");
        menuu.setkodeitem("");
        menuu.setjumlah("");
    }

//    private class simpanpegawai implements ActionListener {
//
//        public simpanpegawai() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("bisakok");
////bagas
//            try {
//                if (menuu.getNamaPegawai().equalsIgnoreCase("")
//                        || menuu.getTanggallahir().equalsIgnoreCase("")
//                        || menuu.getAlamat().equalsIgnoreCase("")
//                        || menuu.getNotelp().equalsIgnoreCase("")
//                        || menuu.getUser().equalsIgnoreCase("")
//                        || menuu.getPass().equalsIgnoreCase("")) {
//                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
//                } else {
//                    int jabatan = 0;
//                    if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("karyawan")) {
//                        jabatan = 1;
//                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("kasir")) {
//                        jabatan = 2;
//                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("kasir")) {
//                        jabatan = 2;
//                    } else {
//                        jabatan = 4;
//                    }
//
//                    int jeniskelamin = 0;
//                    if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("laki laki")) {
//                        jeniskelamin = 2;
//                    } else if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("perempuan")) {
//                        jeniskelamin = 3;
//                    } else {
//                        jeniskelamin = 4;
//                    }
//                    modell.simpan("public.datapegawai(kodepegawai, namapegawai,idlevel, id_jeniskelamin, tgllahir, alamat, notelp, usernamee, passwordd)"
//                            + " VALUES (DEFAULT, ' " + menuu.getNamaPegawai() + "', " + jabatan + ", " + jeniskelamin + ", ' " + menuu.getTanggallahir() + "', ' "
//                            + menuu.getAlamat() + "', ' " + menuu.getNotelp() + "', ' " + menuu.getUser() + "', ' " + menuu.getPass() + "')");
//                    menuu.setTabel(modell.getTablepegawai());
//                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
//                    resetpegawai();
//                    menuu.showCard("datapegawai");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ckasir_pegawai.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//    }
}
