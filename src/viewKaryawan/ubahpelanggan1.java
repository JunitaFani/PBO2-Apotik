/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewKaryawan;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author JUNITA
 */
public class ubahpelanggan1 extends javax.swing.JFrame {

    /**
     * Creates new form tambahpelanggan
     */
    public ubahpelanggan1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        batal = new javax.swing.JButton();
        simpan1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        pegawai = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kode = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 420, 50));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pelanggan/batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setBorderPainted(false);
        batal.setContentAreaFilled(false);
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 590, 140, -1));

        simpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pelanggan/simpan.png"))); // NOI18N
        simpan1.setBorder(null);
        simpan1.setBorderPainted(false);
        simpan1.setContentAreaFilled(false);
        simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan1ActionPerformed(evt);
            }
        });
        getContentPane().add(simpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 590, 140, -1));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 420, 50));
        getContentPane().add(pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 70, 30));

        alamat.setBorder(null);
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 408, 410, 40));

        telp.setBorder(null);
        telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpKeyTyped(evt);
            }
        });
        getContentPane().add(telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 491, 410, 40));

        nama.setBorder(null);
        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 241, 410, 40));
        getContentPane().add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 160, 413, 43));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pelanggan/layer tambah pelanggan.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        new dataPelanggan().setVisible(true); 
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_batalActionPerformed

    private void simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan1ActionPerformed
       new dataPelanggan().setVisible(true); 
       dispose();
    }//GEN-LAST:event_simpan1ActionPerformed

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        char nama = evt.getKeyChar();
        if (!(Character.isAlphabetic(nama)
                ||(nama==KeyEvent.VK_BACK_SPACE)
                ||(nama==KeyEvent.VK_DELETE)
                )) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Masukkan karakter huruf");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_namaKeyTyped

    private void telpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpKeyTyped
   char telp = evt.getKeyChar();
        if (!(Character.isDigit(telp)
                ||(telp==KeyEvent.VK_BACK_SPACE)
                ||(telp==KeyEvent.VK_DELETE)
                )) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Harap isi angka");     // TODO add your handling code here:
    }//GEN-LAST:event_telpKeyTyped
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ubahpelanggan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubahpelanggan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubahpelanggan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubahpelanggan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ubahpelanggan1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel kode;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel pegawai;
    private javax.swing.JButton simpan1;
    private javax.swing.JTextField telp;
    // End of variables declaration//GEN-END:variables
}
