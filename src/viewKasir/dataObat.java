/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewKasir;

/**
 *
 * @author JUNITA
 */
public class dataObat extends javax.swing.JPanel {

    /**
     * Creates new form dataObat
     */
    public dataObat() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pilihan1 = new javax.swing.JComboBox<>();
        search1 = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        background1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pilihan = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pilihan1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pilihan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Obat", "Nama Obat" }));
        jPanel1.add(pilihan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 220, 30));

        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/cari.png"))); // NOI18N
        search1.setBorder(null);
        search1.setBorderPainted(false);
        search1.setContentAreaFilled(false);
        jPanel1.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 18, 62, 40));

        txt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt1.setBorder(null);
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 270, 20));

        tabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"
            }
        ));
        jScrollPane2.setViewportView(tabel1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1290, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/layer obat.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 540));

        tabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Satuan", "Harga Box"
            }
        ));
        jScrollPane3.setViewportView(tabel2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1290, 470));

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/layer2.png"))); // NOI18N
        jPanel1.add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 572));

        jTabbedPane1.addTab("Obat Umum", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pilihan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pilihan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Resep", "Dokter" }));
        jPanel2.add(pilihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 220, 30));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/cari.png"))); // NOI18N
        search.setBorder(null);
        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 18, 62, 40));

        txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt.setBorder(null);
        jPanel2.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 270, 20));

        tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode item", "Nama item", "Jenis", "Satuan", "Stok", "Harga ", "Dokter"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1290, 470));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/layer obat.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 540));

        jTabbedPane1.addTab("Obat Beresep", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 570));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataObat/layer obat.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1349, 572));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> pilihan;
    private javax.swing.JComboBox<String> pilihan1;
    private javax.swing.JButton search;
    private javax.swing.JButton search1;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel2;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txt1;
    // End of variables declaration//GEN-END:variables
}
