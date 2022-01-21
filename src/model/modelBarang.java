/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.koneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */

public class modelBarang{
    private String kategoriBarangModel;
    private String ukuranBarangModel;
    private String warnaBarangModel;
    private String merekBarangModel;
    private int stokBarangModel;
    private int hargaBarangModel;
    private int kodeBarangModel;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelBarang(){
        
    }

    public int getKodeBarangModel() {
        return kodeBarangModel;
    }

    public void setKodeBarangModel(int kodeBarangModel) {
        this.kodeBarangModel = kodeBarangModel;
    }
    
    public String getKategoriBarangModel() {
        return kategoriBarangModel;
    }

    public void setKategoriBarangModel(String kategoriBarangModel) {
        this.kategoriBarangModel = kategoriBarangModel;
    }

    public String getUkuranBarangModel() {
        return ukuranBarangModel;
    }

    public void setUkuranBarangModel(String ukuranBarangModel) {
        this.ukuranBarangModel = ukuranBarangModel;
    }

    public String getWarnaBarangModel() {
        return warnaBarangModel;
    }

    public void setWarnaBarangModel(String warnaBarangModel) {
        this.warnaBarangModel = warnaBarangModel;
    }

    public String getMerekBarangModel() {
        return merekBarangModel;
    }

    public void setMerekBarangModel(String merekBarangModel) {
        this.merekBarangModel = merekBarangModel;
    }

    public int getStokBarangModel() {
        return stokBarangModel;
    }

    public void setStokBarangModel(int stokBarangModel) {
        this.stokBarangModel = stokBarangModel;
    }

    public int getHargaBarangModel() {
        return hargaBarangModel;
    }

    public void setHargaBarangModel(int hargaBarangModel) {
        this.hargaBarangModel = hargaBarangModel;
    }
    
    
    public void SimpanDataBarang(){
        String sql= ("INSERT INTO barang (kategori, ukuran, warna, merek, stok, harga)"
                + "VALUES('"+getKategoriBarangModel()+"','"+getUkuranBarangModel()+"','"+
                getWarnaBarangModel()+"','"+getMerekBarangModel()+"',"+getStokBarangModel()+","+
                getHargaBarangModel()+")");
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
        
            JOptionPane.showMessageDialog(null, "Data berhasil Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan \n "+ ex);
        }
    }
    public void UpdateDataBarang(){
        String sql = "UPDATE barang SET kategori = '"+getKategoriBarangModel()+"'"
                + " ,ukuran = '"+getUkuranBarangModel()+"'"
                + " ,warna = '"+getWarnaBarangModel()+"'"
                + " ,merek = '"+getMerekBarangModel()+"'"
                + " ,stok = "+getStokBarangModel()
                + " ,harga = "+getHargaBarangModel()+
                " WHERE kode_barang = "+getKodeBarangModel();
        try{
            PreparedStatement eksekusi= koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal diubah \n"+ ex);
        }
    }
    public void HapusDataBarang(){
        String sql = "DELETE FROM barang WHERE kode_barang ="
                +getKodeBarangModel()+"";
        
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Data gagal dihapus \n" + ex);
        }
    }
}


