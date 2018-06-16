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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JUNITA
 */
public class model_karyawan extends basemodel{
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

//public class arrayList_ObatUmum {
//    private int Id_Obat;
//    private String kodeObat;
//    private String namaObat;
//    private String satuan;
//    private int stok;
//    private int hargaBeli;
//    private int hargaSatuan;
//    private int hargaBox;
//
//        public arrayList_ObatUmum(int Id_Obat, String kodeObat, String namaObat, String satuan, int stok, int hargaBeli, int hargaSatuan, int hargaBox) {
//            this.Id_Obat = Id_Obat;
//            this.kodeObat = kodeObat;
//            this.namaObat = namaObat;
//            this.satuan = satuan;
//            this.stok = stok;
//            this.hargaBeli = hargaBeli;
//            this.hargaSatuan = hargaSatuan;
//            this.hargaBox = hargaBox;
//        }
//
//        public int getId_Obat() {
//            return Id_Obat;
//        }
//
//        public String getKodeObat() {
//            return kodeObat;
//        }
//
//        public String getNamaObat() {
//            return namaObat;
//        }
//
//        public String getSatuan() {
//            return satuan;
//        }
//
//        public int getStok() {
//            return stok;
//        }
//
//        public int getHargaBeli() {
//            return hargaBeli;
//        }
//
//        public int getHargaSatuan() {
//            return hargaSatuan;
//        }
//
//        public int getHargaBox() {
//            return hargaBox;
//        }
//
//}
//   public ArrayList<arrayList_ObatUmum> getObatUmum() {
//        ArrayList<arrayList_ObatUmum> ObatUmum = new ArrayList<arrayList_ObatUmum>();
//        Statement st;
//        ResultSet rs;
//        arrayList_ObatUmum ou;
//
//        String sql = "SELECT o.Id_Obat, o.kodeObat, o.namaObat, s.satuan, o.stok, o.hargaBeli, o.hargaSatuan, o.hargaBox,\n"
//                + "	FROM public.obat o join satuan s on s.id_Satuan = o.id_Satuan;";
//
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                ou = new arrayList_ObatUmum(rs.getInt("Id_Obat"),
//                        rs.getString("kodeObat"),
//                        rs.getString("namaObat"),
//                        rs.getString("satuan"),
//                        rs.getInt("stok"),
//                        rs.getInt("hargaBeli"),
//                        rs.getInt("hargaSatuan"),
//                        rs.getInt("hargaBox"));
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
//    public boolean insertObatUmum(String kodeObat, String namaObat, String satuan, int stok, int hargaBeli, int hargaSatuan, int hargaBox) {
//        String query = "INSERT INTO public.obat(\n"
//                + "	Id_Obat, kodeObat, namaObat, satuan, stok, hargaBeli, hargaSatuan, hargaBox)\n"
//                + "	VALUES (DEFAULT, ?, ?, ?, ?, ?, ? ,?);";
//
//        boolean hasil = false;
//
//        try {
//            PreparedStatement st = conn.prepareStatement(query);
//            st.setString(2, kodeObat);
//            st.setString(3, namaObat);
//            st.setString(4, satuan);
//            st.setInt(5, stok);
//            st.setInt(6, hargaBeli);
//            st.setInt(7, hargaSatuan);
//            st.setInt(8, hargaBox);
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
    
    public DefaultTableModel getTableObatUmum() throws SQLException {
        Object[] header = {"Id_Obat", "kodeObat", "namaObat", "satuan", "stok", "hargaBeli", "hargaSatuan", "hargaBox"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        String sql = "SELECT o.Id_Obat, o.kodeObat, o.namaObat, s.satuan, o.isi, o.stok, o.hargaBeli, o.hargaSatuan, o.hargaBox\n" +
                     "FROM public.obat o join satuan s on s.id_Satuan = o.id_Satuan";
        System.out.println(sql);
        Statement st;
        ResultSet rs;
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        st = conn.createStatement();
        rs = st.executeQuery(sql);
//        ResultSet rs = con.getResult(sql);
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
        Object[] header = {"Id_Obat", "kodeObat", "namaObat", "satuan", "isi", "stok", "hargaBeli", "hargaSatuan", "hargaBox"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT o.Id_Obat, o.kodeObat, o.namaObat, s.satuan, o.isi, o.stok, o.hargaBeli, o.hargaSatuan, o.hargaBox\n" +
                     "FROM public.obat o join satuan s on s.id_Satuan = o.id_Satuan where o.kodeObat = "+query;
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
    
    public String[] comboSatuan() throws SQLException {
        String query = "SELECT satuan FROM public.satuan";
        String db = "Apotik";
        String username = "postgres";
        String password = "junita123";
        String url = "jdbc:postgresql://localhost:5432/" + db;
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Statement stmq = con.createStatement();
        ResultSet rs = stmt.executeQuery();
        rs.getRow();
        rs.last();
        String satuan[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            satuan[a] = rs.getString("satuan");
            a++;
        }
        return satuan;
    }

}
