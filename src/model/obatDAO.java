/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author JUNITA
 */
    public class obatDAO extends basemodel {

  
    public obatDAO() throws SQLException {
        super();
    }

    public ArrayList<obat> getAllobat() throws SQLException, ParseException {
        ArrayList<obat> a = new ArrayList<>();
        String sql = "SELECT * FROM dataobat";
        ResultSet rs = this.con.getResult(sql);
        while (rs.next()) {
            obat o = new obat();
            o.setid_obat(rs.getInt("id_obat"));
            o.setnamaobat(rs.getString("namaobat"));
            o.setHarga(this.parse(rs.getString("hargasatuan"),Locale.US).doubleValue());
            a.add(o);
        }
        return a;
    }

    public BigDecimal parse(final String amount, final Locale locale) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
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
