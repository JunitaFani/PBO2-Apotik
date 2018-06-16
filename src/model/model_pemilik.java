/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import apotek.koneksi;
import java.sql.SQLException;

/**
 *
 * @author JUNITA
 */
public class model_pemilik extends basemodel{
    koneksi con;
//    public String status;

    public model_pemilik(koneksi con) throws SQLException {
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
}
