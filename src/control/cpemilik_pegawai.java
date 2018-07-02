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
import model.model_pemilik;
import view.menu_pemilik;

/**
 *
 * @author JUNITA
 */
public class cpemilik_pegawai {

    private menu_pemilik menuu;
    private model_pemilik modell;
    String username;
    private int kodepegawai;
    private String namapegawai;
    private int jabatan;
    private int jeniskelamin;
    private String tgllahir;
    private String alamat;
    private String notelpon;
    private String user;
    private String pass;

    public cpemilik_pegawai(model_pemilik modell, menu_pemilik menuu) throws SQLException {
        this.menuu = menuu;
        this.modell = modell;
        //data pegawai
        menuu.setTabel(modell.getTablepegawai());
        menuu.tabelpegawai(new tabelpegawai());
        menuu.datapegawaiListener(new datapegawaiListener());
        menuu.buttonUbahpegawai(true);
        menuu.buttonHapuspegawai(true);
        menuu.buttonTambahpegawai(true);
        menuu.setComboBox_jabatan(modell.combojabatan());
        menuu.setComboBox_jeniskelamin(modell.combojeniskelamin());
        menuu.getUbahpegawai().addActionListener(new getUbahPegawai());
        menuu.ubahSimpanpegawai().addActionListener(new ubahSimpanpegawai());
        menuu.HapuspegawaiListener(new HapuspegawaiListener());
        resetpegawai();
        menuu.simpanpegawai().addActionListener(new simpanpegawai());
        menuu.tambahpegawai().addActionListener(new tambahpegawai());
        menuu.setVisible(true);
        menuu.showCard("datapegawai");
        menuu.batal().addActionListener(new batalPegawai());
        menuu.kembaliMenu().addActionListener(new kembaliMenu());
        //obat resep
    }

    private class kembaliMenu implements ActionListener {

        public kembaliMenu() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cpemilik_menu(modell, menuu);
        }

    }

    public void resetpegawai() {
        menuu.setNama("");
        menuu.setUser("");
        menuu.setPass("");
        menuu.setAlamat("");
        menuu.setNotelp("");
        menuu.tanggalLahir().setDate(null);
    }

    private class batalPegawai implements ActionListener {

        public batalPegawai() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            menuu.showCard("datapegawai");
            try {
                menuu.setTabel(modell.getTablepegawai());
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_pegawai.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class tabelpegawai implements MouseListener {

        public tabelpegawai() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel model = (DefaultTableModel) menuu.gettabelpegawai().getModel();
            menuu.gettabelpegawai().setEnabled(false);
            kodepegawai = Integer.parseInt(model.getValueAt(menuu.getBaristabelpegawai(), 0).toString());
            namapegawai = model.getValueAt(menuu.getBaristabelpegawai(), 1).toString();
            String getjabatan = model.getValueAt(menuu.getBaristabelpegawai(), 2).toString();
            String getjeniskelamin = model.getValueAt(menuu.getBaristabelpegawai(), 3).toString();
            tgllahir = model.getValueAt(menuu.getBaristabelpegawai(), 4).toString();
            alamat = model.getValueAt(menuu.getBaristabelpegawai(), 5).toString();
            notelpon = model.getValueAt(menuu.getBaristabelpegawai(), 6).toString();
            user = model.getValueAt(menuu.getBaristabelpegawai(), 7).toString();
            pass = model.getValueAt(menuu.getBaristabelpegawai(), 8).toString();

            System.out.println("getTabelPegawai" + kodepegawai);

            menuu.gettabelpegawai().setEnabled(false);
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

    private static class datapegawaiListener implements ActionListener {

        public datapegawaiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class tambahpegawai implements ActionListener {

        public tambahpegawai() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuu.showCard("tb_datapegawai");
        }
    }

    private class simpanpegawai implements ActionListener {

        public simpanpegawai() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("bisakok");
//bagas
            try {
                if (menuu.getNamaPegawai().equalsIgnoreCase("")
                        || menuu.getTanggallahir().equalsIgnoreCase("")
                        || menuu.getAlamat().equalsIgnoreCase("")
                        || menuu.getNotelp().equalsIgnoreCase("")
                        || menuu.getUser().equalsIgnoreCase("")
                        || menuu.getPass().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
                } else {
                    int jabatan = 0;
                    if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("karyawan")) {
                        jabatan = 1;
                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("kasir")) {
                        jabatan = 2;
                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("pemilik")) {
                        jabatan = 2;
                    } else {
                        jabatan = 4;
                    }

                    int jeniskelamin = 0;
                    if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("laki laki")) {
                        jeniskelamin = 2;
                    } else if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("perempuan")) {
                        jeniskelamin = 3;
                    } else {
                        jeniskelamin = 4;
                    }
                    modell.simpan("public.datapegawai(kodepegawai, namapegawai,idlevel, id_jeniskelamin, tgllahir, alamat, notelp, usernamee, passwordd)"
                            + " VALUES (DEFAULT, '" + menuu.getNamaPegawai() + "', " + jabatan + ", " + jeniskelamin + ", ' " + menuu.getTanggallahir() + "', '"
                            + menuu.getAlamat() + "', '" + menuu.getNotelp() + "', '" + menuu.getUser() + "', '" + menuu.getPass() + "')");
                    menuu.setTabel(modell.getTablepegawai());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetpegawai();
                    menuu.showCard("datapegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_pegawai.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class HapuspegawaiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBaristabelpegawai() < 0) {
                JOptionPane.showMessageDialog(menuu, "Pilih data terlebih dahulu");
            } else {
                int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menghapus data ini?", "Hapus", JOptionPane.YES_NO_OPTION);
                System.out.println("pilih = " + pilih);
                if (pilih == JOptionPane.YES_OPTION) {
                    try {
                        int baris = menuu.getBaristabelpegawai();
                        String kodepegawai = menuu.getValueAt(baris, 0);
                        System.out.println(kodepegawai);
                        modell.hapus("datapegawai WHERE kodepegawai ='" + kodepegawai + "'");
                        menuu.setTabel(modell.getTablepegawai());
                    } catch (SQLException ex) {
                        Logger.getLogger(cpemilik_pegawai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                menuu.gettabelpegawai().clearSelection();
                menuu.gettabelpegawai().setEnabled(true);
            }
        }
    }

    private class getUbahPegawai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (menuu.getBaristabelpegawai() < 0) {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
            } else {
                DefaultTableModel model = (DefaultTableModel) menuu.gettabelpegawai().getModel();
                menuu.setnamapegawai().setText(namapegawai);
                menuu.getJabatan().setSelectedIndex(jabatan);
                menuu.setalamat().setText(alamat);
                menuu.setnotelp().setText(notelpon);
                menuu.getJeniskelamin().setSelectedIndex(jeniskelamin);
                menuu.setUserr().setText(user);
                menuu.setPassw().setText(pass);
//                menuu.tanggalLahir().setDateFormatString(tgllahir);
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tgllahir);
                    menuu.tanggalLahir().setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(cpemilik_pegawai.class.getName()).log(Level.SEVERE, null, ex);
                }
                menuu.showCard("tb_datapegawai");
                menuu.ubahSimpanpegawai().setVisible(true);
                menuu.simpanpegawai().setVisible(false);
                menuu.simpanpegawai().invalidate();

            }
        }
    }

    private class ubahSimpanpegawai implements ActionListener {

        public ubahSimpanpegawai() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (menuu.getNamaPegawai().equalsIgnoreCase("")
                        || menuu.getTanggallahir().equalsIgnoreCase("")
                        || menuu.getAlamat().equalsIgnoreCase("")
                        || menuu.getNotelp().equalsIgnoreCase("")
                        || menuu.getUser().equalsIgnoreCase("")
                        || menuu.getPass().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(menuu, "Data Tidak Boleh Kosong!!!");
                } else {
                    int jabatan = 0;
                    if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("karyawan")) {
                        jabatan = 1;
                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("kasir")) {
                        jabatan = 2;
                    } else if (menuu.getJabatan().getSelectedItem().toString().equalsIgnoreCase("pemilik")) {
                        jabatan = 2;
                    } else {
                        jabatan = 4;
                    }

                    int jeniskelamin = 0;
                    if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("laki laki")) {
                        jeniskelamin = 2;
                    } else if (menuu.getJeniskelamin().getSelectedItem().toString().equalsIgnoreCase("perempuan")) {
                        jeniskelamin = 3;
                    } else {
                        jeniskelamin = 4;
                    }

                    int baris = menuu.getBaristabelpegawai();
                    String namapegawai = menuu.getNamaPegawai();
                    String tanggallahir = menuu.getTanggallahir();
                    String alamat = menuu.getAlamat();
                    String notelp = menuu.getNotelp();
                    String kodepegawai = menuu.getValueAt(baris, 0);
                    String pass = menuu.getPass();
                    String user = menuu.getUser();
                    modell.perbarui("public.datapegawai SET namapegawai='" + namapegawai + "',idlevel=" + jabatan + ",id_jeniskelamin=" + jeniskelamin + ", "
                            + "tgllahir='" + tanggallahir + "', alamat='" + alamat + "', notelp='" + notelp + "', usernamee='" + user + "', password='" + pass + "'WHERE kodepegawai = " + kodepegawai + ";");

                    menuu.setTabel(modell.getTablepegawai());
                    JOptionPane.showMessageDialog(menuu, "data berhasil disimpan");
                    resetpegawai();
                    menuu.showCard("datapegawai");
                    menuu.gettabelpegawai().clearSelection();
                    menuu.gettabelpegawai().setEnabled(true);
                    menuu.ubahSimpanpegawai().setVisible(false);
                    menuu.simpanpegawai().setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(cpemilik_pegawai.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
