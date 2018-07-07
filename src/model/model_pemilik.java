/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUNITA
 */
public class model_pemilik extends basemodel {

    koneksi con;
    Connection conn;

    public model_pemilik() throws SQLException {
        super();
        con = new koneksi("postgres", "junita123", "Apotik");
    }

    public model_pemilik(koneksi con) throws SQLException {
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
    public DefaultTableModel getTablepegawai() throws SQLException {
        Object[] header = {"Kode Pegawai", "Nama Pegawai", "Jabatan", "Jenis Kelamin", "Tanggal Lahir", "Alamat", "No Telepon", "Username", "Password"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        String sql = "SELECT p.kodepegawai, p.namapegawai, l.level, j.jeniskelamin, p.tgllahir, p.alamat, p.notelp, usernamee, passwordd\n"
                + "  FROM public.datapegawai p JOIN public.tb_level l ON p.idlevel = l.idlevel \n"
                + "JOIN public.jeniskelamin j ON p.id_jeniskelamin = j.id_jeniskelamin order by p.kodepegawai asc;";
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

    public String[] combojabatan() throws SQLException {
        String query = "SELECT level FROM public.tb_level";
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
        String level[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            level[a] = rs.getString("level");
            a++;
        }
        return level;
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

    public DefaultTableModel getTableModelcarilaporan(String query) throws SQLException {
        Object[] header = {"Id Tagihan", "Tanggal", "Id pegawai", "Id Obat", "Nama Obat", "Total Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, o.kodepegawai, pd.id_obat, pd.namaobat, dps.jumlah,(dps.harga * dps.jumlah) as total \n"
                + "FROM public.datatagihan ps join public.detail_tagihan dps on dps.kodetagihan = ps.kodetagihan \n"
                + "join public.dataobat pd on dps.id_obat = pd.id_obat join public.datapegawai o on ps.kodepegawai = o.kodepegawai \n"
                + " where ps.tanggal = " + query;

        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[6];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public DefaultTableModel getTableModelLaporan() throws SQLException {
        Object[] header = {"Id Tagihan", "Tanggal", "Id pegawai", "Id Obat", "Nama Obat", "Total Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, o.kodepegawai, pd.id_obat, pd.namaobat, dps.jumlah,(dps.harga * dps.jumlah) as total \n"
                + "FROM public.datatagihan ps join public.detail_tagihan dps on dps.kodetagihan = ps.kodetagihan join public.dataobat pd on dps.id_obat = pd.id_obat \n"
                + "join public.datapegawai o on ps.kodepegawai = o.kodepegawai ORDER BY kodetagihan ASC;";
        System.out.println(sql);

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[6];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }
    
    public DefaultTableModel getTableModelcarilaporanobat(String query) throws SQLException {
        Object[] header = {"Id Tagihan", "Tanggal",  "Id Obat", "Nama Obat", "Jumlah", "Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, pd.id_obat, pd.namaobat, dps.jumlah, dps.harga\n"
                + "FROM public.datatagihan ps join public.detail_tagihan dps on dps.kodetagihan = ps.kodetagihan \n"
                + "join public.dataobat pd on dps.id_obat = pd.id_obat\n"
                + " where ps.tanggal = " + query;

        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[6];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public DefaultTableModel getTableModelLaporanobat() throws SQLException {
        Object[] header = {"Id Tagihan", "Tanggal",  "Id Obat", "Nama Obat", "Jumlah", "Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, pd.id_obat, pd.namaobat, dps.jumlah,dps.harga\n"
                + "FROM public.datatagihan ps join public.detail_tagihan dps on dps.kodetagihan = ps.kodetagihan join public.dataobat pd on dps.id_obat = pd.id_obat ORDER BY kodetagihan ASC;";
        System.out.println(sql);

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[6];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }
}
