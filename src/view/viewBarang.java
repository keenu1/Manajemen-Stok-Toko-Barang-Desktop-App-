/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerBarang;
import database.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class viewBarang extends javax.swing.JFrame {

    private controllerBarang cB;
    private DefaultTableModel model;
    private String kategoriBarang;
    private String sql;
    
    public viewBarang(){
        initComponents();
        cB = new controllerBarang(this);
        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("KodeBarang");
        model.addColumn("Kategori");
        model.addColumn("Ukuran");
        model.addColumn("Warna");
        model.addColumn("Merek");
        model.addColumn("Stok");
        model.addColumn("Harga");
        
        
        tampilDataBarang();
        cB.kontrolButton();
    }
    private void tampil(){
        try{
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
          
            while(res.next()){
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("kode_barang");
                hasil[1] = res.getString("kategori");
                hasil[2] = res.getString("ukuran");
                hasil[3] = res.getString("warna");
                hasil[4] = res.getString("merek");
                hasil[5] = res.getString("stok");
                hasil[6] = res.getString("harga");
            
                model.addRow(hasil);
            }
        } catch (SQLException ex){
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tampilDataBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        sql = "SELECT * FROM barang";
        tampil();
    }
    private void tampilDataBarangBaju(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        sql = "SELECT * FROM barang WHERE kategori='Baju'";
        tampil();
    }
    private void tampilDataBarangHoodie(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        sql = "SELECT * FROM barang WHERE kategori='Hoodie'";
        tampil();
    }
    private void tampilDataBarangTopi(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        sql = "SELECT * FROM barang WHERE kategori='Topi'";
        tampil();
    }
    private void tampilDataBarangSepatu(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        sql = "SELECT * FROM barang WHERE kategori='Sepatu'";
        tampil();
    }
    
    private void ambilDataTabel(){
        
        int index = tabelBarang.getSelectedRow();
        String kodeBarang = String.valueOf(tabelBarang.getValueAt(index, 0));
        String kategori = String.valueOf(tabelBarang.getValueAt(index, 1));
        String ukuran = String.valueOf(tabelBarang.getValueAt(index, 2));
        String warna = String.valueOf(tabelBarang.getValueAt(index, 3));
        String merek= String.valueOf(tabelBarang.getValueAt(index, 4));
        String stok = String.valueOf(tabelBarang.getValueAt(index, 5));
        String harga = String.valueOf(tabelBarang.getValueAt(index, 6));
        
        kodeBarangTF.setText(kodeBarang);
        switch (kategori) {
            case "Baju":
                kategoriCB.setSelectedIndex(1);
                break;
            case "Hoodie":
                kategoriCB.setSelectedIndex(2);
                break;
            case "Topi":
                kategoriCB.setSelectedIndex(3);
                break;
            case "Sepatu":
                kategoriCB.setSelectedIndex(4);
                break;
            default:
                kategoriCB.setSelectedIndex(0);
                break;
        }
        ukuranTF.setText(ukuran);
        warnaTF.setText(warna);
        merekTF.setText(merek);
        stokSP.setValue(Integer.valueOf(stok));
        hargaTF.setText(harga);
        
        cB.kontrolButton2();
    }
    
    public JButton getTombolSimpan(){
        return simpanBTN;
    }
    public JButton getTombolHapus(){
        return hapusBTN;
    }
    public JButton getTombolEdit(){
        return updateBTN;
    }
    public JButton getTombolBatal(){
        return batalBTN;
    }
    
    public JTextField getKodeBarangView(){
        return kodeBarangTF;
    }
    public JComboBox getKategoriBarangView(){
        return kategoriCB;
    }
    public JTextField getUkuranBarangView(){
        return ukuranTF;
    }
    public JTextField getWarnaBarangView(){
        return warnaTF;
    }
    public JTextField getMerekBarangView(){
        return merekTF;
    }
    public JSpinner getStokBarangView(){
        return stokSP;
    }
    public JTextField getHargaBarangView(){
        return hargaTF;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        kodeBarangTF = new javax.swing.JTextField();
        warnaTF = new javax.swing.JTextField();
        merekTF = new javax.swing.JTextField();
        hargaTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        batalBTN = new javax.swing.JButton();
        simpanBTN = new javax.swing.JButton();
        hapusBTN = new javax.swing.JButton();
        updateBTN = new javax.swing.JButton();
        ukuranTF = new javax.swing.JTextField();
        kategoriCB = new javax.swing.JComboBox<>();
        stokSP = new javax.swing.JSpinner();
        Sortir1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        sortir2 = new javax.swing.JButton();
        sortir3 = new javax.swing.JButton();
        sortir4 = new javax.swing.JButton();
        defaultBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management Barang ByrCloth");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText(" Management Barang Toko BYRCLOTH");

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Kategori ");

        jLabel4.setText("Ukuran ");

        jLabel5.setText(":");

        jLabel6.setText("Warna");

        jLabel7.setText("Merek");

        jLabel8.setText("Stok");

        jLabel9.setText("Harga");

        jLabel10.setText(":");

        jLabel11.setText(":");

        jLabel12.setText(":");

        jLabel13.setText(":");

        jLabel14.setText(":");

        jLabel15.setText(":");

        kodeBarangTF.setEnabled(false);

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        batalBTN.setText("Batal");
        batalBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTNActionPerformed(evt);
            }
        });

        simpanBTN.setText("Simpan");
        simpanBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTNActionPerformed(evt);
            }
        });

        hapusBTN.setText("Hapus");
        hapusBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTNActionPerformed(evt);
            }
        });

        updateBTN.setText("Update");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        kategoriCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Selected Item-", "Baju", "Hoodie", "Topi", "Sepatu" }));

        Sortir1.setText("Baju");
        Sortir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sortir1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Sortir Berdasakan :");

        sortir2.setText("Hoodie");
        sortir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortir2ActionPerformed(evt);
            }
        });

        sortir3.setText("Topi");
        sortir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortir3ActionPerformed(evt);
            }
        });

        sortir4.setText("Sepatu");
        sortir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortir4ActionPerformed(evt);
            }
        });

        defaultBTN.setText("Default");
        defaultBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(kodeBarangTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(warnaTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(merekTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hargaTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ukuranTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kategoriCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stokSP, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Sortir1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sortir2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(simpanBTN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateBTN)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sortir3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sortir4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(batalBTN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hapusBTN)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(defaultBTN)
                        .addGap(112, 112, 112)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(kodeBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(kategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(ukuranTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(warnaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(merekTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14)
                            .addComponent(stokSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(hargaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanBTN)
                            .addComponent(hapusBTN)
                            .addComponent(batalBTN)
                            .addComponent(updateBTN))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sortir1)
                            .addComponent(sortir2)
                            .addComponent(sortir3)
                            .addComponent(sortir4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(defaultBTN))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTNActionPerformed
        cB.simpan();
        tampilDataBarang();
    }//GEN-LAST:event_simpanBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        cB.update();
        tampilDataBarang();
    }//GEN-LAST:event_updateBTNActionPerformed

    private void batalBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTNActionPerformed
        cB.kontrolButton();
        cB.bersihkan();
    }//GEN-LAST:event_batalBTNActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        ambilDataTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void hapusBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTNActionPerformed
        cB.hapus();
        tampilDataBarang();
    }//GEN-LAST:event_hapusBTNActionPerformed

    private void Sortir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sortir1ActionPerformed
        tampilDataBarangBaju();
    }//GEN-LAST:event_Sortir1ActionPerformed

    private void sortir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortir2ActionPerformed
        tampilDataBarangHoodie();
    }//GEN-LAST:event_sortir2ActionPerformed

    private void sortir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortir3ActionPerformed
        tampilDataBarangTopi();
    }//GEN-LAST:event_sortir3ActionPerformed

    private void sortir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortir4ActionPerformed
        tampilDataBarangSepatu();
    }//GEN-LAST:event_sortir4ActionPerformed

    private void defaultBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultBTNActionPerformed
        tampilDataBarang();
    }//GEN-LAST:event_defaultBTNActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sortir1;
    private javax.swing.JButton batalBTN;
    private javax.swing.JButton defaultBTN;
    private javax.swing.JButton hapusBTN;
    private javax.swing.JTextField hargaTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategoriCB;
    private javax.swing.JTextField kodeBarangTF;
    private javax.swing.JTextField merekTF;
    private javax.swing.JButton simpanBTN;
    private javax.swing.JButton sortir2;
    private javax.swing.JButton sortir3;
    private javax.swing.JButton sortir4;
    private javax.swing.JSpinner stokSP;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField ukuranTF;
    private javax.swing.JButton updateBTN;
    private javax.swing.JTextField warnaTF;
    // End of variables declaration//GEN-END:variables
}
