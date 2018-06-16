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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_karyawan;
import model.model_login;
import viewKaryawan.menu;
import viewKasir.login;


/**
 *
 * @author JUNITA
 */
public class ckaryawan {
    private menu menuu;
    private model_karyawan modell;
    String username;
        public ckaryawan(model_karyawan modell, menu menuu ) throws SQLException {
        this.menuu = menuu;
        this.modell = modell;

//        menuu.setTabel(modell.getTableObatUmum());
        menuu.obatListener(new obatListener());
        menuu.buttonUbah(false);
        menuu.buttonHapus(false);
        menuu.buttonTambah(true);
//        menuu.laporanObatListener(new laporanObatListener());
//        menuu.laporanPelangganListener(new laporanPelangganListener());
//        menuu.profilListener(new profilListener());
//        menuu.logoutListener(new logoutListener());
//        menuu.UbahObatUmumListener(new  UbahObatUmumListener());
//        menuu.HapusObatUmumListener(new HapusObatUmumListener());
//        menuu.pelangganListener(new pelangganListener());
        
        menuu.setVisible(true);
        menuu.showCard("dataObat");

//        setObatUmum();
        menuu.simpan().addActionListener(new simpanObatUmum());
        menuu.tambahObatUmum().addActionListener(new getTambahObatUmum());

    }

        public void resetObatUmum() {
        menuu.setKode("");
        menuu.setNama("");
        menuu.setIsi("");
        menuu.setStok("");
        menuu.setHargaBeli("");
        menuu.setHargaSatuan("");
        menuu.setHargaBox("");

    }
        
    private static class obatListener implements ActionListener {

        public obatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    
    private class getTambahObatUmum implements ActionListener {

        public getTambahObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("tb_ObatUmum");
        }
    }

//    public void setObatUmum() {
//        DefaultTableModel model = new DefaultTableModel();
//        Object[] columnsName = new Object[8];
//
//        columnsName[0] = "No.";
//        columnsName[1] = "Kode";
//        columnsName[2] = "Nama Obat";
//        columnsName[3] = "Satuan";
//        columnsName[4] = "Stok";
//        columnsName[5] = "Harga Beli";
//        columnsName[6] = "Harga Satuan";
//        columnsName[7] = "Harga Box";
//
//        model.setColumnIdentifiers(columnsName);
//
//        Object[] rowData = new Object[8];
//
//        for (int i = 0; i < modell.getObatUmum().size(); i++) {
//            rowData[0] = modell.getObatUmum().get(i).getId_Obat();
//            rowData[1] = modell.getObatUmum().get(i).getKodeObat();
//            rowData[2] = modell.getObatUmum().get(i).getNamaObat();
//            rowData[3] = modell.getObatUmum().get(i).getSatuan();
//            rowData[4] = modell.getObatUmum().get(i).getStok();
//            rowData[5] = modell.getObatUmum().get(i).getHargaBeli();
//            rowData[6] = modell.getObatUmum().get(i).getHargaSatuan();
//            rowData[7] = modell.getObatUmum().get(i).getHargaBox();
//            
//            System.out.println(rowData[0]);
//
//            model.addRow(rowData);
//        }
//        menuu.getTabelObatUmum().setModel(model);
//    }

    private class tambahObatUmum implements ActionListener {

        public tambahObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("tb_ObatUmum");
        }
    }

    private class simpanObatUmum implements ActionListener {

        public simpanObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                        System.out.println("bisakok");
            try {
                if (menuu.getKode().equalsIgnoreCase("")
                        || menuu.getNamaObat().equalsIgnoreCase("")
                        || menuu.getSatuan().getSelectedItem().toString().equalsIgnoreCase("")
                        || menuu.getIsi().equalsIgnoreCase("")
                        || menuu.getStok().equalsIgnoreCase("")
                        || menuu.getHargaBeli().equalsIgnoreCase("")
                        || menuu.getHargaSatuan().equalsIgnoreCase("")
                        || menuu.getHargaBox().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data tidak boleh ada yang kosong!!!");
                } else {
                    int satuan = 0;
                    if (menuu.getSatuan().equals("Botol")) {
                        satuan = 1;
                    } else if (menuu.getSatuan().equals("Tablet")) {
                        satuan = 2;
                    } else {
                        satuan = 3;
                    }

                    modell.simpan("public.buku(Id_Obat, kodeObat, namaObat, isi, stok, hargaBeli, hargaSatuan, hargaBox, id_Satuan, \"tb_users\")"
                            + " VALUES (default, ' " + menuu.getKode() + "', '"
                            + menuu.getNamaObat() + "', '" + menuu.getIsi() + "','" + menuu.getStok() + "', '"
                            + menuu.getHargaBeli() + "', " + menuu.getHargaSatuan() + ", '"
                            + menuu.getHargaBox() + "', " + satuan + ", " + user.getIdLogin() + ")");
                    menuu.setTabel(modell.getTableObatUmum());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    menuu.showCard("dataObat");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
//            String kodeObat = menuu.getKode();
//            String namaObat = menuu.getNamaObat();
//            String satuan = menuu.getSatuan().getSelectedItem().toString();
//            String stok = menuu.getStok();
//            String hargaBeli = menuu.getHargaBeli();
//            String hargaSatuan = menuu.getHargaSatuan();
//            String hargaBox = menuu.getHargaBeli();
//            
//            if (kode_matakuliah.trim().isEmpty() || nama_matakuliah.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(menuu, "Lengkapi data");
//            } else {
//                if (modell.insertObatUmum(kodeObat, namaObat, satuan, 0, 0, 0, 0))) {
//                    JOptionPane.showMessageDialog(menuu, "Data berhasil ditambahkan");
//
//                    menuu.showCard("dataObat");
//                    setObatUmum();
//
//                } else {
//                    JOptionPane.showMessageDialog(menuu, "Data gagal ditambahkan");
//                }
//            }
//        
//        
        }
    }

}
