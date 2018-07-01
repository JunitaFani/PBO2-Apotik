/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.model_kasir;
import viewKasir.menu;

/**
 *
 * @author JUNITA
 */
public class ckasir_datakas extends ckasir_menu{
    
         private menu menuu;
    private model_kasir modell;
    private String tgldaftar;
    private int kodepelanggan;
    private int jeniskelamin;
    private String namapelanggan;
    private String tgllahir;
    private String alamat;
    private String notelpon;

    public ckasir_datakas(model_kasir modell, menu menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;
        menuu.showCard("datakas");
//        menuu.setTabelpelanggan(modell.getTablepelanggan());
//        menuu.tabelpelanggan(new tabelpelanggan());
        menuu.kembaliMenu5().addActionListener(new kembaliMenu());
//        menuu.SearchObatUmum(new SearchPelanggan());
//        menuu.segarkanListener(new segarkanListener());
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckasir_menu(modell, menuu);
        }

    }

//    private class tabelpelanggan implements MouseListener {
//
//        public tabelpelanggan() {
//        }
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            DefaultTableModel model = (DefaultTableModel) menuu.gettabelpelanggan().getModel();
//            menuu.gettabelpelanggan().setEnabled(false);
//            kodepelanggan = Integer.parseInt(model.getValueAt(menuu.getBaristabelpelanggan(), 0).toString());
//            tgldaftar = model.getValueAt(menuu.getBaristabelpelanggan(), 1).toString();
//            namapelanggan = model.getValueAt(menuu.getBaristabelpelanggan(), 2).toString();
//            String getjeniskelamin = model.getValueAt(menuu.getBaristabelpelanggan(), 3).toString();
//            tgllahir = model.getValueAt(menuu.getBaristabelpelanggan(), 4).toString();
//            alamat = model.getValueAt(menuu.getBaristabelpelanggan(), 5).toString();
//            notelpon = model.getValueAt(menuu.getBaristabelpelanggan(), 6).toString();
//
//            System.out.println("getTabelPegawai" + kodepelanggan);
//
//            menuu.gettabelpelanggan().setEnabled(false);
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//        }
//
//    }
//
//    private class SearchPelanggan implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            try {
//                menuu.setTabelpelanggan(modell.getTablepelanggancari("'" + menuu.gettxtsearch() + "'"));
//            } catch (SQLException ex) {
//                Logger.getLogger(ckaryawan_laporanpelanggan.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    private class segarkanListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                menuu.setTabelpelanggan(modell.getTablepelanggan());
//            } catch (SQLException ex) {
//                Logger.getLogger(ckaryawan_laporanpelanggan.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
}
