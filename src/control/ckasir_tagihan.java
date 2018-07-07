/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.itemtransaksi;
import model.model_kasir;
import view.menu_kasir;
import model.obat;
import model.obatDAO;

/**
 *
 * @author JUNITA
 */
public class ckasir_tagihan {

    model_kasir modell;
    menu_kasir menuu;
    String username;
    obatDAO obatdao;
    ArrayList<obat> listobat;

    ckasir_tagihan(model_kasir modell, menu_kasir menuu) throws SQLException, ParseException {
        this.modell = modell;
        this.menuu = menuu;
        menuu.setVisible(true);
        menuu.showCard("dataTagihan");
        menuu.kembaliMenu().addActionListener(new kembaliMenu());
        resettagihan();
        obatdao = new obatDAO();
        listobat = obatdao.getAllobat();
        this.menuu.OKListener(new TambahListener());
        this.menuu.SimpanListener(new SaveListener());
        this.menuu.HapusListener(new HapusListener());
        this.menuu.btnKembaliListener(new kembaliMenu());
        this.menuu.addobatList(listobat);

    }

    public void resettagihan() {
        menuu.settgl("");
        menuu.setPelanggan("");
        menuu.setjumlah("");
    }
    String totalx;
    Double plustotal;
    Double plustotalx;

    class TambahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            obat o = listobat.get(menuu.getobatSelected());
            menuu.addItem(o.getnamaobat(), o.getid_obat() + "", menuu.getJumlah2(), o.getHarga());

            plustotal = menuu.getJumlah2() * o.getHarga();
            if (menuu.getTotalBiaya().equalsIgnoreCase("")) {
                double ttl = 0;
                double ttlx = ttl + plustotal;
                totalx = String.valueOf(ttlx);
                menuu.setTotal3(totalx);
            } else {
                Double ttl = Double.parseDouble(menuu.getTotalBiaya());
                double ttlx = ttl + plustotal;
                  totalx = String.valueOf(ttlx);
                menuu.setTotal3(totalx);
            }
        }
    }

        class HapusListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double totSkg = Double.parseDouble(menuu.getTotalBiaya());
                    double tot2 = menuu.getSelectedQty2() * menuu.getSelectedHarga2();
                    double total = totSkg - tot2;
//                double totals = total - plustotal;
                    menuu.setTotal3(total + "");

//                menuu.minTotal2(menuu.getSelectedQty2() * menuu.getSelectedHarga2());
                    menuu.hapusItem2(menuu.getRow2());
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }

        class SaveListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = menuu.getModel();
                ArrayList<itemtransaksi> list = new ArrayList<>();

                for (int i = 0; i < model.getRowCount(); i++) {
                    itemtransaksi item = new itemtransaksi();
                    item.setHarga(Double.parseDouble(model.getValueAt(i, 2).toString()));
                    item.setid_obat(Integer.parseInt(model.getValueAt(i, 0).toString()));
                    item.setjumlah((int) Double.parseDouble(model.getValueAt(i, 3).toString()));
                    list.add(item);
                }
                try {
                    double bayar = Double.parseDouble(menuu.getBayar());
                    double total = Double.parseDouble(menuu.getTotalBiaya());
                    double kembalian = bayar - total;
                    menuu.setKembalian(String.valueOf(kembalian));
                    modell.saveTransaksi(menuu.getNamaPelanggan(), menuu.getObatSelected(),Double.parseDouble(menuu.gettotal().toString()),list);
                    System.out.println(""+modell.saveTransaksi(menuu.getNamaPelanggan(), menuu.getObatSelected(),Double.parseDouble(menuu.getTotalBiaya().toString()),list));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }

        private class kembaliMenu implements ActionListener {

            public kembaliMenu() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                new ckasir_menu(modell, menuu);
            }

        }

//
//    private menu_kasir menuu;
//    private model_kasir modell;
//    String username;
//    obatDAO obatdao;
//    ArrayList<obat> listobat;
//
//    public ckasir_tagihan(model_kasir modell, menu_kasir menuu) throws SQLException, ParseException {
//        this.menuu = menuu;
//        this.modell = modell;
//        menuu.setVisible(true);
//        menuu.showCard("dataTagihan");
//        menuu.kembaliMenu().addActionListener(new kembaliMenu());
//        resettagihan();
//        obatdao = new obatDAO();
//        listobat = obatdao.getAllobat();
//        menuu.addObatList(listobat);
//        this.menuu.OKListener(new TambahListener());
//        this.menuu.SimpanListener(new SimpanListener());       
//        this.menuu.HapusListener(new HapusListener());
//    }
//
//    private class kembaliMenu implements ActionListener {
//
//        public kembaliMenu() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            new ckasir_menu(modell, menuu);
//        }
//
//    }
//
//    public void resettagihan() {
//        menuu.settgl("");
//        menuu.setPelanggan("");
//        menuu.setjumlah("");
//    }
//
//        class HapusListener implements ActionListener {
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            menuu.minTotal(menuu.getSelectedJumlah()*menuu.getSelectedHarga());
//            menuu.hapusItem(menuu.getRow());
//        }
//    }
//    
//    private class TambahListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            obat o = listobat.get(menuu.getObatSelected());
//            menuu.addNamaObat(o.getid_obat() + "", o.getnamaobat(), menuu.getjumlah(),o.getHarga());
//            menuu.plusTotal(menuu.getjumlah()*o.getHarga());
//            
//        }
//    }
//
//   private class SimpanListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            DefaultTableModel model = menuu.getModel();
//            ArrayList<itemtransaksi> list = new ArrayList<>();
//            
//            for (int i = 0; i < model.getRowCount(); i++) {
//                itemtransaksi item = new itemtransaksi();
//                item.setHarga(Double.parseDouble(model.getValueAt(i, 2).toString()));
//                item.setkodeobat(Integer.parseInt(model.getValueAt(i, 0).toString()));
//                item.setjumlah((int) Double.parseDouble(model.getValueAt(i, 3).toString()));
//                list.add(item);
//            }
//            try {
//                modell.saveTransaksi(menuu.getNama(), list);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    
//   }
    
    }

