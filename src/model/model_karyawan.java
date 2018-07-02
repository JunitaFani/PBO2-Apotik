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

/**
 *
 * @author JUNITA
 */
public class model_karyawan extends basemodel {

    koneksi con;
    Connection conn;

    public model_karyawan() throws SQLException {
        super();
        con = new koneksi("postgres", "junita123", "Apotik");
    }

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

//bagas
    public DefaultTableModel getTableObatUmum() throws SQLException {
        Object[] header = {"Kode Obat", "Nama Obat", "Satuan", "Isi", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        String sql = "SELECT d.id_obat, d.namaobat, s.satuan, d.isi, d.stok, d.hargabeli, d.hargasatuan, d.hargabox\n"
                + "  FROM public.dataobat d JOIN public.satuan s ON d.id_satuan = s.id_satuan order by d.id_obat asc;";
        System.out.println(sql);

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[8];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public DefaultTableModel getTableObatUmumCari(String query) throws SQLException {
        Object[] header = {"Kode Obat", "Nama Obat", "Satuan", "Isi", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT d.id_obat, d.namaobat, s.satuan, d.isi, d.stok, d.hargabeli, d.hargasatuan, d.hargabox\n"
                + "  FROM public.dataobat d join public.satuan s on d.id_satuan = s.id_satuan order by d.id_obat asc where namaobat = " + query;
        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[8];
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

    public String[] combojeniskelamin() throws SQLException {
        String query = "SELECT jeniskelamin FROM public.jeniskelamin";
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
        String jeniskelamin[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            jeniskelamin[a] = rs.getString("jeniskelamin");
            a++;
        }
        return jeniskelamin;
    }

    //blm
    public DefaultTableModel getTableModelcari(String query) throws SQLException {
        Object[] header = {"id_pemesanan", "Tujuan", "Penjemputan", "Tanggal Berangkat", "Jenis Transport", "Lama Tour", "nama Pemesan"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT p.id_pemesanan, t.nama_kota, p.penjemputan, p.tglberangkat, ts.jenis_transport, \n"
                + "       p.lama, a.nama_pelanggan\n"
                + "  FROM public.\"Pemesanan\" p join tujuan t on p.id_kota = t.id_kota join transport ts on p.id_transport = ts.id_transport join akun a on p.id_akun = a.id_akun where p.tglberangkat =" + query;
        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

}
