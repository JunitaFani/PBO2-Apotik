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
public class ubahresep extends javax.swing.JFrame {

    /**
     * Creates new form tambahobatresep
     */
    public ubahresep() {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        simpan1 = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        kode = new javax.swing.JLabel();
        dokter = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        pilihan = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Obat", "Nama Obat" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 160, 160, 30));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 60, 50));

        tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode item", "Nama item", "Satuan", "Stok", "Harga "
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1290, 290));

        simpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pelanggan/simpan.png"))); // NOI18N
        simpan1.setBorder(null);
        simpan1.setBorderPainted(false);
        simpan1.setContentAreaFilled(false);
        simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan1ActionPerformed(evt);
            }
        });
        getContentPane().add(simpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 600, 140, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pelanggan/batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setBorderPainted(false);
        batal.setContentAreaFilled(false);
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 600, 140, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 272, 30));
        getContentPane().add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 110, 265, 25));

        dokter.setBorder(null);
        getContentPane().add(dokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 59, 265, 22));

        nama.setBorder(null);
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 110, 265, 22));

        total.setBorder(null);
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 160, 265, 22));

        pilihan.setBorder(null);
        getContentPane().add(pilihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 160, 265, 22));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/tmbh resep.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan1ActionPerformed
         new dataObat().setVisible(true);
         dispose();
    }//GEN-LAST:event_simpan1ActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
         new dataObat().setVisible(true);  
         dispose();// TODO add your handling code here:
    }//GEN-LAST:event_batalActionPerformed
 private void dokterKeyTyped(java.awt.event.KeyEvent evt) {                                
        char dokter = evt.getKeyChar();
        if (!(Character.isAlphabetic(dokter)
                ||(dokter==KeyEvent.VK_BACK_SPACE)
                ||(dokter==KeyEvent.VK_DELETE)
                )) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Masukkan karakter huruf");
        }         // TODO add your handling code here:
    }                               

    private void totalKeyTyped(java.awt.event.KeyEvent evt) {                               
 char total = evt.getKeyChar();
        if (!(Character.isDigit(total)
                ||(total==KeyEvent.VK_BACK_SPACE)
                ||(total==KeyEvent.VK_DELETE)
                )) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Harap isi angka");        // TODO add your handling code here:
    }                              
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
            java.util.logging.Logger.getLogger(ubahresep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubahresep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubahresep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubahresep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ubahresep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    private javax.swing.JTextField dokter;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField pilihan;
    private javax.swing.JButton simpan1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
