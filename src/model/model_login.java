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


/**
 *
 * @author JUNITA
 */
public class model_login extends basemodel{
    private koneksi con;
    private basemodel base;
    private String[] session = new String[3];

    public model_login() throws SQLException {
        con = new koneksi("postgres", "junita123", "Apotik") {
            @Override
            public void execute(String sql) throws SQLException {

            }
        };
    }

    public void getSession(String username, String password) throws SQLException {
        String query = "select \"iduser\", nama from public.tb_users where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = con.getResult(query);
        while (rs.next()) {
            user.setIdLogin(rs.getString("idUser"));
            user.setUserLogin(rs.getString("username"));
        }

    }

    public int lvlLogin(String username, String password) throws SQLException {
        int level = 0;
        String query = "select level from tb_users where username='" + username + "' and password='" + password + "'";
        ResultSet rs = con.getResult(query);
        rs.next();
        level = Integer.valueOf(rs.getString(1));
        return level;

    }

    public int login(String username, String password) throws SQLException {
        int result = 0;

        String query = "select username from tb_users where username='" + username + "' and password='" + password + "'";
        ResultSet rs = con.getResult(query);
        rs.last();
        result = rs.getRow();
        return result;

    }
    
    
    @Override
    public boolean simpan(String query) throws SQLException {
        String queri = "INSERT INTO " + query;
        System.out.println(queri);
        return super.save(queri);

    }

    @Override
    public boolean perbarui(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hapus(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

