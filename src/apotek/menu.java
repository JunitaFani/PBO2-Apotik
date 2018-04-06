/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.awt.GridBagLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author JUNITA
 */
public class menu extends javax.swing.JFrame {
    GridBagLayout layout = new GridBagLayout();
    dataObat p1;
    dataPelanggan p2;
    dataTagihan p3;
    dataKas p4;
    profil p5;
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        p1 = new dataObat();
        p2 = new dataPelanggan();
        p3 = new dataTagihan();
        p4 = new dataKas();
        p5 = new profil();
        
        panel.setLayout(layout);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p5);
        
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        obat = new javax.swing.JButton();
        pelanggan = new javax.swing.JButton();
        tagihan = new javax.swing.JButton();
        kas = new javax.swing.JButton();
        profil = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1349, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1349, 572));

        obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/obat.png"))); // NOI18N
        obat.setBorder(null);
        obat.setBorderPainted(false);
        obat.setContentAreaFilled(false);
        obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obatActionPerformed(evt);
            }
        });
        getContentPane().add(obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 225, 77));

        pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/pelanggan.png"))); // NOI18N
        pelanggan.setBorder(null);
        pelanggan.setBorderPainted(false);
        pelanggan.setContentAreaFilled(false);
        pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelangganActionPerformed(evt);
            }
        });
        getContentPane().add(pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 0, 225, 77));

        tagihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/tagihan.png"))); // NOI18N
        tagihan.setBorder(null);
        tagihan.setBorderPainted(false);
        tagihan.setContentAreaFilled(false);
        tagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagihanActionPerformed(evt);
            }
        });
        getContentPane().add(tagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 225, 77));

        kas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/kas.png"))); // NOI18N
        kas.setBorder(null);
        kas.setBorderPainted(false);
        kas.setContentAreaFilled(false);
        kas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasActionPerformed(evt);
            }
        });
        getContentPane().add(kas, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 0, 225, 77));

        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/profil.png"))); // NOI18N
        profil.setBorder(null);
        profil.setBorderPainted(false);
        profil.setContentAreaFilled(false);
        profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilActionPerformed(evt);
            }
        });
        getContentPane().add(profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 225, 77));

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/logout.png"))); // NOI18N
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 0, 225, 77));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/layer2.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obatActionPerformed
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
    }//GEN-LAST:event_obatActionPerformed

    private void pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganActionPerformed
        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
    }//GEN-LAST:event_pelangganActionPerformed

    private void tagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagihanActionPerformed
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
        p4.setVisible(false);
        p5.setVisible(false);
    }//GEN-LAST:event_tagihanActionPerformed

    private void kasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasActionPerformed
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(true);   
        p5.setVisible(false);
    }//GEN-LAST:event_kasActionPerformed

    private void profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilActionPerformed
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);   
        p5.setVisible(true);
    }//GEN-LAST:event_profilActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
//                  logout frame = new logout();
//                  frame.setVisible(true);
                int confirm = JOptionPane.showConfirmDialog(this,
                "Konfirmasi Keluar Aplikasi",
                "Yakin untuk keluar dari program",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);}
    }//GEN-LAST:event_logoutActionPerformed
    
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton kas;
    private javax.swing.JButton logout;
    private javax.swing.JButton obat;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pelanggan;
    private javax.swing.JButton profil;
    private javax.swing.JButton tagihan;
    // End of variables declaration//GEN-END:variables
}
