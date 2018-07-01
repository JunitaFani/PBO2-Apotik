/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author JUNITA
 */
import apotek.koneksi;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_karyawan;
import viewKaryawan.dataObat;
import viewKaryawan.dataPelanggan;
import viewKaryawan.menu;
import viewKaryawan.tambahObat2;
import viewKasir.login;

/**
 *
 * @author JUNITA
 */
public class ckaryawan_obat extends ckaryawan_menu {

    private menu menuu;
    private model_karyawan modell;
    private login loginn;
    private int kodeobat;
    private String namaobat;
    private int satuan;
    private int isi;
    private int stok;
    private int hargabeli;
    private int hargasatuan;
    private int hargabox;
    koneksi con;
    String username;

    public ckaryawan_obat(model_karyawan modell, menu menuu) throws SQLException {
        super(modell, menuu);
        this.menuu = menuu;
        this.modell = modell;
        menuu.showCard("dataObat");
        //obat umum
        menuu.setTabel(modell.getTableObatUmum());
        menuu.tabelListener(new getTabelObatUmum());
        menuu.obatListener(new obatListener());
        menuu.buttonUbah(true);
        menuu.buttonHapus(true);
        menuu.buttonTambah(true);
        menuu.setComboBox_Satuan(modell.comboSatuan());
        menuu.getUbah().addActionListener(new getUbahObatUmum());
        menuu.ubahSimpan().addActionListener(new ubahSimpanObatUmum());
        menuu.HapusObatUmumListener(new HapusObatUmumListener());
        menuu.simpan().addActionListener(new simpanObatUmum());
        menuu.tambahObatUmum().addActionListener(new tambahObatUmum());
        menuu.SearchObatUmum(new SearchObatUmum());
        menuu.segarkan2Listener(new segarkanListener());
        resetObatUmum();
        menuu.kembaliMenu2().addActionListener(new kembaliMenu());
        menuu.batal().addActionListener(new batalObatUmum());
    }
//obat umum

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ckaryawan_menu(modell,menuu);
        }

    }

    public void resetObatUmum() {
        menuu.setNama("");
        menuu.setIsi("");
        menuu.setStok("");
        menuu.setHargaBeli("");
        menuu.setHargaSatuan("");
        menuu.setHargaBox("");

    }
    
       private class batalObatUmum implements ActionListener {

        public batalObatUmum() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            menuu.showCard("dataObat");
            try {
                menuu.setTabel(modell.getTableObatUmum());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class getTabelObatUmum implements MouseListener {

        public getTabelObatUmum() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            DefaultTableModel model = (DefaultTableModel) menuu.getTabelObatUmum().getModel();
            menuu.getTabelObatUmum().setEnabled(false);
            kodeobat = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 0).toString());
            namaobat = model.getValueAt(menuu.getBarisObatUmum(), 1).toString();
            String getsatuan = model.getValueAt(menuu.getBarisObatUmum(), 2).toString();
            isi = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 3).toString());
            stok = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 4).toString());
            hargabeli = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 5).toString());
            hargasatuan = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 6).toString());
            hargabox = Integer.parseInt(model.getValueAt(menuu.getBarisObatUmum(), 7).toString());

            System.out.println("getTabelObatUmum" + kodeobat);

            menuu.getTabelObatUmum().setEnabled(false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class obatListener implements ActionListener {

        public obatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("dataObat");
        }
    }

    private class tambahObatUmum implements ActionListener {

        public tambahObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("tb_ObatUmum");
        }
    }

    private class simpanObatUmum implements ActionListener {

        public simpanObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("bisakok");
//bagas
            try {
                if (menuu.getNamaObat().equalsIgnoreCase("")
                        || menuu.getIsi().equalsIgnoreCase("")
                        || menuu.getStok().equalsIgnoreCase("")
                        || menuu.getHargaBeli().equalsIgnoreCase("")
                        || menuu.getHargaSatuan().equalsIgnoreCase("")
                        || menuu.getHargaBox().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data tidak boleh ada yang kosong!!!");
                } else {
                    int satuan = 0;
                    if (menuu.getSatuan().getSelectedItem().toString().equalsIgnoreCase("Tablet")) {
                        satuan = 1;
                    } else if (menuu.getSatuan().getSelectedItem().toString().equalsIgnoreCase("Botol")) {
                        satuan = 2;
                    } else {
                        satuan = 3;
                    }

                    modell.simpan("public.dataobat(id_obat, namaobat, id_satuan, isi, stok, hargabeli, hargasatuan,hargabox)"
                            + " VALUES (DEFAULT, '" + menuu.getNamaObat() + "', " + satuan + ", '" + menuu.getIsi() + "', '"
                            + menuu.getStok() + "', '" + menuu.getHargaBeli() + "', '" + menuu.getHargaSatuan() + "','" + menuu.getHargaBox() + "' )");
                    menuu.setTabel(modell.getTableObatUmum());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetObatUmum();
                    menuu.showCard("dataObat");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class HapusObatUmumListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBarisObatUmum() < 0) {
                JOptionPane.showMessageDialog(menuu, "Pilih data terlebih dahulu");
            } else {
                int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menghapus data ini?", "Hapus", JOptionPane.YES_NO_OPTION);
                System.out.println("pilih = " + pilih);
                if (pilih == JOptionPane.YES_OPTION) {
                    try {
                        int baris = menuu.getBarisObatUmum();
                        String kodeobat = menuu.getValueAt(baris, 0);
                        System.out.println(kodeobat);
                        modell.hapus("dataobat WHERE id_obat ='" + kodeobat + "'");
                        menuu.setTabel(modell.getTableObatUmum());
                    } catch (SQLException ex) {
                        Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                menuu.getTabelObatUmum().clearSelection();
                menuu.getTabelObatUmum().setEnabled(true);
            }
        }
    }

    private class getUbahObatUmum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBarisObatUmum() < 0) {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
            } else {
                DefaultTableModel model = (DefaultTableModel) menuu.getTabelObatUmum().getModel();
                menuu.setNamaObat().setText(namaobat);
                menuu.getSatuan().setSelectedIndex(satuan);
                menuu.setIsi().setText(Integer.toString(isi));
                menuu.setStok().setText(Integer.toString(stok));
                menuu.setHargaBeli().setText(Integer.toString(hargabeli));
                menuu.setHargaSatuan().setText(Integer.toString(hargasatuan));
                menuu.setHargaBox().setText(Integer.toString(hargabox));
                menuu.showCard("tb_ObatUmum");
                menuu.ubahSimpan().setVisible(true);
                menuu.simpan().setVisible(false);
                menuu.simpan().invalidate();

            }
        }
    }

    private class ubahSimpanObatUmum implements ActionListener {

        public ubahSimpanObatUmum() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (menuu.getNamaObat().equalsIgnoreCase("")
                        || menuu.getIsi().equalsIgnoreCase("")
                        || menuu.getStok().equalsIgnoreCase("")
                        || menuu.getHargaBeli().equalsIgnoreCase("")
                        || menuu.getHargaSatuan().equalsIgnoreCase("")
                        || menuu.getHargaBox().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
                } else {
                    int satuan = 0;
                    if (menuu.getSatuan().getSelectedItem().toString().equalsIgnoreCase("Tablet")) {
                        satuan = 1;
                    } else if (menuu.getSatuan().getSelectedItem().toString().equalsIgnoreCase("Botol")) {
                        satuan = 2;
                    } else {
                        satuan = 3;
                    }

                    int baris = menuu.getBarisObatUmum();
                    String namaObat = menuu.getNamaObat();
                    int isi = Integer.parseInt(menuu.getIsi());
                    int stok = Integer.parseInt(menuu.getStok());
                    int hargaBeli = Integer.parseInt(menuu.getHargaBeli());
                    int hargaSatuan = Integer.parseInt(menuu.getHargaSatuan());
                    int hargaBox = Integer.parseInt(menuu.getHargaBox());
                    String id_obat = menuu.getValueAt(baris, 0);
                    modell.perbarui("public.dataobat SET namaobat='" + namaObat
                            + "', id_satuan=" + satuan + ", isi='" + isi + "', stok='" + stok
                            + "', hargabeli='" + hargaBeli + "',hargasatuan='" + hargaSatuan
                            + "',hargabox='" + hargaBox + "'WHERE id_obat = " + id_obat + ";");

                    menuu.setTabel(modell.getTableObatUmum());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetObatUmum();
                    menuu.showCard("dataObat");
                    menuu.getTabelObatUmum().clearSelection();
                    menuu.getTabelObatUmum().setEnabled(true);
                    menuu.ubahSimpan().setVisible(false);
                    menuu.simpan().setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class SearchObatUmum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                menuu.setTabel(modell.getTableObatUmumCari("'" + menuu.gettxtsearch1() + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class segarkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                menuu.setTabel(modell.getTableObatUmum());
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan_obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//obat resep
//
//    private class tabelResepListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int i = menuu.getBarisObatUmum();
//            if (i < 0) {
//                menuu.showCard("tb_ObatUmum");
//
//            }
//            if (menuu.getBarisObatUmum() < 0) {
//                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
//            } else {
//                DefaultTableModel model = (DefaultTableModel) menuu.getTabelObatUmum().getModel();
////                menuu.setkodeObat().setText(kodeobat);
//                menuu.setNamaObat().setText(namaobat);
//                menuu.getSatuan().setSelectedIndex(satuan);
//                menuu.setIsi().setText(Integer.toString(isi));
//                menuu.setStok().setText(Integer.toString(stok));
//                menuu.setHargaBeli().setText(Integer.toString(hargabeli));
//                menuu.setHargaSatuan().setText(Integer.toString(hargasatuan));
//                menuu.setHargaBox().setText(Integer.toString(hargabox));
//                menuu.showCard("tb_ObatUmum");
//                menuu.ubahSimpan().setVisible(true);
//                menuu.simpan().setVisible(false);
//                menuu.simpan().invalidate();
//
//            }
//        }
//    }
}


