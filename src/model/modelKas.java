/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUNITA
 */
public class modelKas {
    private Connection koneksi;
    public modelKas() {
//        koneksi = new koneksi().koneksi();
    }
    
    public DefaultTableModel bacaKas() {
        String query = "SELECT p.id, b.nama, p.username, p.password FROM pengguna p JOIN bio b WHERE p.level = 'user';";
        String namaKolom[] = {"No. Transaksi", "Tanggal", "Pelanggan", "Kode Item",
        "Nama Item", "Jumlah", "Satuan", "Harga", "Sub Total", "Pegawai"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[10];
                
                data[0] = rs.getInt(6);
                data[1] = rs.getDate(8);
                data[2] = rs.getString(15);
                data[3] = rs.getString(6);
                data[4] = rs.getString(15);
                data[5] = rs.getInt(3);
                data[6] = rs.getString(10);
                data[7] = rs.getLong(8);
                data[8] = rs.getLong(8);
                data[9] = rs.getString(15);                
                
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return tabel;
    }
}
