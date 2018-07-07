/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import control.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUNITA
 */
public class model_kasir extends basemodel {

    koneksi con;
    Connection conn;
//    public String status;

    public model_kasir() throws SQLException {
        super();
        con = new koneksi("postgres", "junita123", "Apotik");
    }

    public model_kasir(koneksi con) throws SQLException {
        super();
        this.con = new koneksi("postgres", "junita123", "Apotik");
    }

    @Override
    protected boolean simpan(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean perbarui(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean hapus(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
                + "  FROM public.dataobat d join public.satuan s on d.id_satuan = s.id_satuan where namaobat = " + query;
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

    public boolean saveTransaksi(String namapelanggan, int idobat, double total, ArrayList<itemtransaksi> list) throws SQLException {
        String sqlpegawai = "SELECT kodepegawai FROM datapegawai WHERE usernamee = '" + user.getUserLogin() + "';";
        
        ResultSet rs = con.getResult(sqlpegawai);
        rs.next();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        
        String queri = "INSERT INTO datatagihan ( kodetagihan,  namapelanggan, tanggal, kodepegawai, total ) VALUES (default, '" + namapelanggan + "','" + df.format(now) + "'," + rs.getString("kodepegawai") + ",'" + total + "' )";
        
        super.save(queri);
        queri = "SELECT * FROM datatagihan ORDER BY kodetagihan DESC";
        System.out.println("3 "+queri);
        rs = con.getResult(queri);
        rs.next();
        
        String kodetagihan = rs.getString("kodetagihan");
        for (int i = 0; i < list.size(); i++) {
            queri = "INSERT INTO detail_tagihan( kodetagihan, id_obat, jumlah, harga) VALUES ( " + kodetagihan + "," + list.get(i).getid_obat() + ","
                    + list.get(i).getjumlah() + "," + list.get(i).getHarga() + " )";
            super.save(queri);

        }

        return true;
    }
        
    
        public DefaultTableModel getTableModelcarilaporan(String query) throws SQLException {
        Object[] header = {"Id Tagihan", "Tanggal", "nama pegawai", "Id Obat", "Nama Obat", "Total Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, o.namapegawai, pd.id_obat, pd.namaobat, dps.jumlah,(dps.harga * dps.jumlah) as total \n"
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
        Object[] header = {"Id Tagihan", "Tanggal", "nama pegawai", "Id Obat", "Nama Obat", "Total Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT ps.kodetagihan, ps.tanggal, o.namapegawai, pd.id_obat, pd.namaobat, dps.jumlah,(dps.harga * dps.jumlah) as total \n"
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

}
