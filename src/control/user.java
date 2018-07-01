/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import apotek.koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_karyawan;
import model.model_kasir;
import model.model_login;
import model.model_pemilik;
import viewKasir.login;


/**
 *
 * @author JUNITA
 */
public class user {
    private login loginn = new login();
    private model_login modelLogin;
    private static String username;
    private static String id;
    private koneksi con;
 
public user(login loginn, model_login modelLogin) throws SQLException {
        this.loginn = loginn;
        this.modelLogin = modelLogin;
        loginn.setVisible(true);
        loginn.loginListener(new LoginListener());
        loginn.resetListener(new resetListener());
    }
    private class resetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        loginn.setUsername("");
        loginn.setPassword("");
        }
    }
    public static void setIdLogin(String id) {
        user.id = id;
    }
    public static String getIdLogin() {
        return id;
    }
    public static void setUserLogin(String username) {
        user.username = username;
    }
    public static String getUserLogin() {
        return username;
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modelLogin.getSession(loginn.getUsername(), loginn.getPassword());
                int result = modelLogin.login(loginn.getUsername(), loginn.getPassword());
                System.out.println(result);
                if (result == 1) {
                    int level = modelLogin.lvlLogin(loginn.getUsername(), loginn.getPassword());

                    if (level == 1) {
                        viewKasir.menu kasir = new viewKasir.menu();
                        loginn.dispose();
                        kasir.setVisible(true);
                        model_kasir model = new model_kasir(con);
                        new ckasir_menu(model, kasir);
                    } else if (level == 2) {
                        viewKaryawan.menu karyawan = new viewKaryawan.menu();                      
                          loginn.dispose();
                        karyawan.setVisible(true);
                        model_karyawan model = new model_karyawan(con);
                        new ckaryawan_menu(model, karyawan);
                    }else if (level == 3) {
                        viewPemilik.menu pemilik= new viewPemilik.menu();
                        loginn.dispose();
                        pemilik.setVisible(true);
                        model_pemilik model = new model_pemilik(con);
                        new cpemilik_menu(model, pemilik);
                    }
                } else if ((loginn.getUsername().equalsIgnoreCase("") || loginn.getPassword().equalsIgnoreCase(""))) {
                    JOptionPane.showMessageDialog(loginn, "Username dan Password tidak Boleh Kosong");
                } else {
                    JOptionPane.showMessageDialog(loginn, "USERNAME ATAU PASSWORD ANDA SALAH !");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(loginn, "Koneksi time out!");
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
       
  

}
