/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_karyawan;
import viewKaryawan.menu;

/**
 *
 * @author JUNITA
 */
public final class cpelanggan {

    private menu menuu;
    private model_karyawan modell;
    private String tgldaftar;
    private int kodepelanggan;
    private int jeniskelamin;
    private String namapelanggan;
    private String tgllahir;
    private String alamat;
    private String notelpon;

    public cpelanggan(model_karyawan modell, menu menuu) throws SQLException {
        this.menuu = menuu;
        this.modell = modell;
        menuu.setVisible(true);
        menuu.showCard("dataPelanggan");
        menuu.setTabelpelanggan(modell.getTablepelanggan());
        menuu.tabelpelanggan(new tabelpelanggan());
        menuu.buttonUbahpelanggan(true);
        menuu.buttonHapuspelanggan(true);
        menuu.buttonTambahpelanggan(true);
        menuu.setComboBox_jk(modell.combojeniskelamin());
        menuu.getUbahpelanggan().addActionListener(new getUbahPelanggan());
        menuu.ubahSimpanpelanggan().addActionListener(new ubahSimpanpelanggan());
        menuu.HapuspelangganListener(new HapuspelangganListener());
        resetpelanggan();
        menuu.simpanpelanggan().addActionListener(new simpanpelanggan());
        menuu.tambahpelanggan().addActionListener(new tambahpelanggan());
    }

    public void resetpelanggan() {
        menuu.setNamaPelanggan("");
        menuu.setAlamat("");
        menuu.setNotelp("");
        menuu.tanggalLahir().setDate(null);
        menuu.tanggalDaftar().setDate(null);
    }

    private class tabelpelanggan implements MouseListener {

        public tabelpelanggan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel model = (DefaultTableModel) menuu.gettabelpelanggan().getModel();
            menuu.gettabelpelanggan().setEnabled(false);
            kodepelanggan = Integer.parseInt(model.getValueAt(menuu.getBaristabelpelanggan(), 0).toString());
            tgldaftar = model.getValueAt(menuu.getBaristabelpelanggan(), 1).toString();
            namapelanggan = model.getValueAt(menuu.getBaristabelpelanggan(), 2).toString();
            String getjeniskelamin = model.getValueAt(menuu.getBaristabelpelanggan(), 3).toString();
            tgllahir = model.getValueAt(menuu.getBaristabelpelanggan(), 4).toString();
            alamat = model.getValueAt(menuu.getBaristabelpelanggan(), 5).toString();
            notelpon = model.getValueAt(menuu.getBaristabelpelanggan(), 6).toString();

            System.out.println("getTabelPegawai" + kodepelanggan);

            menuu.gettabelpelanggan().setEnabled(false);
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

    private class tambahpelanggan implements ActionListener {

        public tambahpelanggan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("tb_dataPelanggan");
        }
    }

    private class simpanpelanggan implements ActionListener {

        public simpanpelanggan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("bisakok");
//bagas
            try {
                if (menuu.getNamaPelanggan().equalsIgnoreCase("")
                        || menuu.getTanggalDaftar().equalsIgnoreCase("")
                        || menuu.getTanggallahir().equalsIgnoreCase("")
                        || menuu.getAlamat().equalsIgnoreCase("")
                        || menuu.getNotelp().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
                } else {
                    int jeniskelamin = 0;
                    if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("laki laki")) {
                        jeniskelamin = 2;
                    } else if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("perempuan")) {
                        jeniskelamin = 3;
                    } else {
                        jeniskelamin = 4;
                    }
                    modell.simpan("public.datapelanggan(kodepelanggan, tanggaldaftar, namapelanggan, id_jeniskelamin, tgllahir, alamat, notelp)"
                            + " VALUES (DEFAULT, '" + menuu.getTanggalDaftar() + "', '" + menuu.getNamaPelanggan() + "', " + jeniskelamin + ", '" + menuu.getTanggallahir() + "', ' "
                            + menuu.getAlamat() + "', '" + menuu.getNotelp() + "')");
                    menuu.setTabelpelanggan(modell.getTablepelanggan());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetpelanggan();
                    menuu.showCard("dataPelanggan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(cPemilik.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class HapuspelangganListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBaristabelpelanggan() < 0) {
                JOptionPane.showMessageDialog(menuu, "Pilih data terlebih dahulu");
            } else {
                int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menghapus data ini?", "Hapus", JOptionPane.YES_NO_OPTION);
                System.out.println("pilih = " + pilih);
                if (pilih == JOptionPane.YES_OPTION) {
                    try {
                        int baris = menuu.getBaristabelpelanggan();
                        String kodepegawai = menuu.getValueAt(baris, 0);
                        System.out.println(kodepegawai);
                        modell.hapus("datapelanggan WHERE kodepelanggan ='" + kodepelanggan + "'");
                        menuu.setTabel(modell.getTablepelanggan());
                    } catch (SQLException ex) {
                        Logger.getLogger(ckaryawan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                menuu.gettabelpelanggan().clearSelection();
                menuu.gettabelpelanggan().setEnabled(true);
            }
        }
    }

    private class getUbahPelanggan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBaristabelpelanggan() < 0) {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
            } else {
                DefaultTableModel model = (DefaultTableModel) menuu.gettabelpelanggan().getModel();

                menuu.setnamapelanggan().setText(namapelanggan);
                menuu.getJeniskelamin().setSelectedIndex(jeniskelamin);
                menuu.setAlamatPelanggan().setText(alamat);
                menuu.setNoTelppelanggan().setText(notelpon);
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tgldaftar);
                    menuu.tanggalDaftar().setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(cPemilik.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tgllahir);
                    menuu.tanggalLahir().setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(cPemilik.class.getName()).log(Level.SEVERE, null, ex);
                }
                menuu.showCard("tb_dataPelanggan");
                menuu.ubahSimpanpelanggan().setVisible(true);
                menuu.simpanpelanggan().setVisible(false);
                menuu.simpanpelanggan().invalidate();

            }
        }
    }

    private class ubahSimpanpelanggan implements ActionListener {

        public ubahSimpanpelanggan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (menuu.getNamaPelanggan().equalsIgnoreCase("")
                        || menuu.getTanggalDaftar().equalsIgnoreCase("")
                        || menuu.getTanggallahir().equalsIgnoreCase("")
                        || menuu.getAlamat().equalsIgnoreCase("")
                        || menuu.getNotelp().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
                } else {
                    int jeniskelamin = 0;
                    if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("laki laki")) {
                        jeniskelamin = 2;
                    } else if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("perempuan")) {
                        jeniskelamin = 3;
                    } else {
                        jeniskelamin = 4;
                    }

                    int baris = menuu.getBaristabelpelanggan();
                    String namapegawai = menuu.getNamaPelanggan();
                    String tanggalDaftar = menuu.getTanggalDaftar();
                    String tanggallahir = menuu.getTanggallahir();
                    String alamat = menuu.getAlamat();
                    String notelp = menuu.getNotelp();
                    String kodepelanggan = menuu.getValueAt(baris, 0);
                    modell.perbarui("public.datapegawai SET tanggaldaftar='" + namapelanggan + "',id_jeniskelamin=" + jeniskelamin + ", tanggaldaftar='" + tanggallahir + "', "
                            + "tgllahir='" + tanggallahir + "', alamat='" + alamat + "', notelp='" + notelp + "'WHERE kodepelanggan = " + kodepelanggan + ";");

                    menuu.setTabel(modell.getTablepelanggan());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetpelanggan();

                    menuu.showCard("dataPelanggan");
                    menuu.gettabelpelanggan().clearSelection();
                    menuu.gettabelpelanggan().setEnabled(true);
                    menuu.ubahSimpanpelanggan().setVisible(false);
                    menuu.simpanpelanggan().setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ckaryawan.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
