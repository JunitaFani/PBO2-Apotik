/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import viewKaryawan.menu;

/**
 *
 * @author JUNITA
 */
public class model_karyawan extends basemodel {

    koneksi con;
    Connection conn;
//    public String status;

    public model_karyawan(koneksi con) throws SQLException {
        super();
        this.con = new koneksi("postgres", "junita123", "Apotik");
    }

    @Override
    public boolean simpan(String query) throws SQLException {
        String queri = "INSERT INTO " + query;
        System.out.println(queri);
        return super.save(queri);
    }

    @Override
    public boolean perbarui(String query) throws SQLException {
        String queri = "UPDATE " + query;
        System.out.println(queri);
        return super.update(queri);
    }

    @Override
    public boolean hapus(String query) throws SQLException {
        String queri = "DELETE FROM " + query;
        System.out.println(queri);
        return super.delete(queri);
    }
//ranggi

//    public class arrayList_ObatUmum {
//
//        private int id_obat;
//        private String kodeobat;
//        private String namaobat;
//        private String satuan;
//        private int isi;
//        private int stok;
//        private int hargabeli;
//        private int hargasatuan;
//        private int hargabox;
//
//        public arrayList_ObatUmum(String kodeobat, String namaobat, String satuan, int isi, int stok, int hargabeli, int hargasatuan, int hargabox) {
////            this.id_obat = id_obat;
//            this.kodeobat = kodeobat;
//            this.namaobat = namaobat;
//            this.satuan = satuan;
//            this.isi = isi;
//            this.stok = stok;
//            this.hargabeli = hargabeli;
//            this.hargasatuan = hargasatuan;
//            this.hargabox = hargabox;
//        }
////
////        public int getid_obat() {
////            return id_obat;
////        }
//
//        public String getkodeobat() {
//            return kodeobat;
//        }
//
//        public String getnamaobat() {
//            return namaobat;
//        }
//
//        public String getSatuan() {
//            return satuan;
//        }
//
//        public int getIsi() {
//            return isi;
//        }
//
//        public int getStok() {
//            return stok;
//        }
//
//        public int gethargabeli() {
//            return hargabeli;
//        }
//
//        public int gethargasatuan() {
//            return hargasatuan;
//        }
//
//        public int gethargabox() {
//            return hargabox;
//        }
//
//        public void setId_obat(int id_obat) {
//            this.id_obat = id_obat;
//        }
//
//        public void setKodeobat(String kodeobat) {
//            this.kodeobat = kodeobat;
//        }
//
//        public void setNamaobat(String namaobat) {
//            this.namaobat = namaobat;
//        }
//
//        public void setSatuan(String satuan) {
//            this.satuan = satuan;
//        }
//
//        public void setIsi(int isi) {
//            this.isi = isi;
//        }
//
//        public void setStok(int stok) {
//            this.stok = stok;
//        }
//
//        public void setHargabeli(int hargabeli) {
//            this.hargabeli = hargabeli;
//        }
//
//        public void setHargasatuan(int hargasatuan) {
//            this.hargasatuan = hargasatuan;
//        }
//
//        public void setHargabox(int hargabox) {
//            this.hargabox = hargabox;
//        }
//        
//        
//    }
//
//    public ArrayList<arrayList_ObatUmum> getObatUmum() {
//        ArrayList<arrayList_ObatUmum> ObatUmum = new ArrayList<arrayList_ObatUmum>();
//        Statement st;
//        ResultSet rs;
//        arrayList_ObatUmum ou;
//        String sql = "SELECT id_obat, kodeobat, namaobat, satuan, isi, stok, hargabeli, hargasatuan, \n"
//                + "       hargabox\n"
//                + "  FROM public.dataobat;";
//
//
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                ou = new arrayList_ObatUmum(
//                        rs.getString("kodeobat"),
//                        //rs.getString("kodeobat"),
//                        rs.getString("namaobat"),
//                        rs.getString("satuan"),
//                        rs.getInt("isi"),
//                        rs.getInt("stok"),
//                        rs.getInt("hargabeli"),
//                        rs.getInt("hargasatuan"),
//                        rs.getInt("hargabox"));
//                
//
//                ObatUmum.add(ou);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(model_karyawan.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return ObatUmum;
//    }
//
//    public boolean insertObatUmum(String kodeobat, String namaobat, String satuan, int isi, int stok, int hargabeli, int hargasatuan, int hargabox) {
//        String query = "INSERT INTO public.dataobat(\n"
//                + "            id_obat, kodeobat, namaobat, satuan, isi, stok, hargabeli, hargasatuan, \n"
//                + "            hargabox)\n"
//                + "    VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, \n"
//                + "            ?);";
//
//        boolean hasil = false;
//
//        try {
//            PreparedStatement st = conn.prepareStatement(query);
////            st.setInt(1, id_obat);
//            st.setString(1, kodeobat);
//            st.setString(2, namaobat);
//            st.setString(3, satuan);
//            st.setInt(4, isi);
//            st.setInt(5, stok);
//            st.setInt(6, hargabeli);
//            st.setInt(7, hargasatuan);
//            st.setInt(8, hargabox);
//            st.executeUpdate();
//
//            hasil = true;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(model_karyawan.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return hasil;
//    }
//bagas
    public DefaultTableModel getTableObatUmum() throws SQLException {
        Object[] header = {"id_obat", "Kode", "Nama Obat", "Satuan", "Isi", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        String sql = "SELECT id_obat, kodeobat, namaobat, satuan, isi, stok, hargabeli, hargasatuan, hargabox\n"
                   + "  FROM public.dataobat;";
        System.out.println(sql);

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[9];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public DefaultTableModel getTableObatUmumCari(String query) throws SQLException {
        Object[] header = {"id_obat", "Kode", "Nama Obat", "Satuan", "Isi", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql =  "SELECT id_obat, kodeobat, namaobat, satuan, isi, stok, hargabeli, hargasatuan, hargabox\n"
                   + "  FROM public.dataobat where kodeobat = "+query;
        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[9];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    
}
