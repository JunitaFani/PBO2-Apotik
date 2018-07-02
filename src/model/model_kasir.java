/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import control.user;
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
    
        public boolean saveTransaksi(String namapelanggan,ArrayList<itemtransaksi> list) throws SQLException {
        String sqlpegawai = "SELECT * FROM pegawai WHERE kodepegawai = "+user.getUserLogin();
        ResultSet rs = con.getResult(sqlpegawai);
        rs.next();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        
        String queri = "INSERT INTO tagihan( namapelanggan, tanggal, kodepegawai) VALUES ( '" + namapelanggan + "','"+df.format(now)+"',"+rs.getString("kodepegawai")+" )";
        super.save(queri);
        queri ="SELECT * FROM tagihan ORDER BY kodetagihan DESC";
        rs = con.getResult(queri);
        rs.next();
        String kodetagihan = rs.getString("kodetagihan");
        for (int i = 0; i < list.size(); i++) {
            queri = "INSERT INTO detail_tagihan( kodetagihan, id_obat, jumlah, harga) VALUES ( " + kodetagihan + ","+list.get(i).getid_obat()+","
                    +list.get(i).getjumlah()+","+list.get(i).getHarga()+" )";
            super.save(queri);
        }
        
        return true;
    }
        

//    public boolean saveTransaksi(String namaPelanggan, ArrayList<itemtransaksi> list) throws SQLException {
//        String sqlpegawai = "SELECT * FROM datapegawai WHERE kodepegawai = " + user.getUserLogin();
//        ResultSet rs = con.getResult(sqlpegawai);
//        rs.next();
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate now = LocalDate.now();
//
//        String queri = "INSERT INTO datatagihan( namapelanggan, tanggal, kodepegawai) VALUES ( '" + namaPelanggan + "','" + df.format(now) + "'," + rs.getString("kodepegawai") + " )";
//        super.save(queri);
//        queri = "SELECT * FROM datatagihan ORDER BY kodetagihan DESC";
//        rs = con.getResult(queri);
//        rs.next();
//        String kodetagihan = rs.getString("kodetagihan ");
//        for (int i = 0; i < list.size(); i++) {
//            queri = "INSERT INTO detail_tagihan( kodetagihan, id_obat, jumlah, harga) VALUES ( " + kodetagihan + "," + list.get(i).getkodeobat() + ","
//                    + list.get(i).getjumlah() + "," + list.get(i).getHarga() + " )";
//            super.save(queri);
//        }
//
//        return true;
//    }
  

//    public DefaultTableModel getTableModel() throws SQLException {
//        Object[] header = {"kode tagihan", "namapelanggan", "jumlah", "harga"};
//        DefaultTableModel tableModel = new DefaultTableModel(null, header);
//
//        String sql = "select d.kodetagihan, d.namapelanggan, d.jumlah, o.harga\n"
//                + "from datatagihan d join dataobat o on o.id_obat=d.id_obat";
//
//        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
//            tableModel.removeRow(i);
//        }
//        ResultSet rs = con.getResult(sql);
//        while (rs.next()) {
//            String kolom[] = new String[4];
//            for (int i = 0; i < kolom.length; i++) {
//                kolom[i] = rs.getString(i + 1);
//            }
//            tableModel.addRow(kolom);
//        }
//        return tableModel;
//    }
//
//        public String[] listObat() throws SQLException {
//        String query = "SELECT jenis FROM dataobat";
//        ResultSet rs = con.getResult(query);
//        rs.last();
//        String obat[] = new String[rs.getRow()];
//        rs.beforeFirst();
//        int a = 0;
//        while (rs.next()) {
//            obat[a] = rs.getString("obat");
//            a++;
//        }
//        a = 0;
//        return obat;
//    }
    
    public DefaultTableModel getTablecaritagihan(String query) throws SQLException {
        Object[] header = {"Kode Obat", "Nama Obat", "Jumlah", "Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT d.id_obat, d.namaobat, t.jumlah,d.harga\n"
                + "  FROM public.dataobat d join public.satuan s on d.id_satuan = s.id_satuan "
                + "join detail_tagihan t on t.id_obat = d.id_obat where d.id_obat = " + query;
        System.out.println(sql);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = con.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
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
