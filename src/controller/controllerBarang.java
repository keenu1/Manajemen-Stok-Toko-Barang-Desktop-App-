/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.JOptionPane;
import model.modelBarang;
import view.viewBarang;

/**
 *
 * @author 
 */

public class controllerBarang {
        private modelBarang mB;
        private viewBarang vB;
        private int kategori,stok;
        public controllerBarang(viewBarang vB){
            this.vB = vB;
        }
        
        public void simpan(){
            mB = new modelBarang();
            kategori = vB.getKategoriBarangView().getSelectedIndex();
            
            switch (kategori) {
                case 1:
                    mB.setKategoriBarangModel("Baju");
                    break;
                case 2:
                    mB.setKategoriBarangModel("Hoodie");
                    break;
                case 3:
                    mB.setKategoriBarangModel("Topi");
                    break;
                case 4:
                    mB.setKategoriBarangModel("Sepatu");
                    break;
                default:
                    mB.setKategoriBarangModel("Kosong");
                    break;
            }
            
            mB.setUkuranBarangModel(vB.getUkuranBarangView().getText());
            mB.setWarnaBarangModel(vB.getWarnaBarangView().getText());
            mB.setMerekBarangModel(vB.getMerekBarangView().getText());
            stok = (int) vB.getStokBarangView().getValue();
            if( stok != 0 ){
                mB.setStokBarangModel(stok);
            }else{
                mB.setStokBarangModel(0);
            }
            
            mB.setHargaBarangModel(Integer.parseInt(vB.getHargaBarangView().getText()));
            
            mB.SimpanDataBarang();
            bersihkan();
        }
        
        public void bersihkan(){
            vB.getKategoriBarangView().setSelectedIndex(0);
            vB.getUkuranBarangView().setText("");
            vB.getWarnaBarangView().setText("");
            vB.getMerekBarangView().setText("");
            vB.getStokBarangView().setValue(0);
            vB.getHargaBarangView().setText("");
            vB.getKodeBarangView().setText("");
        }
        
        public void update(){
            mB = new modelBarang();
            mB.setKodeBarangModel(Integer.parseInt(vB.getKodeBarangView().getText()));
            kategori = vB.getKategoriBarangView().getSelectedIndex();
            
            switch (kategori) {
                case 1:
                    mB.setKategoriBarangModel("Baju");
                    break;
                case 2:
                    mB.setKategoriBarangModel("Hoodie");
                    break;
                case 3:
                    mB.setKategoriBarangModel("Topi");
                    break;
                case 4:
                    mB.setKategoriBarangModel("Sepatu");
                    break;
                default:
                    mB.setKategoriBarangModel("Kosong");
                    break;
            }
            mB.setUkuranBarangModel(vB.getUkuranBarangView().getText());
            mB.setWarnaBarangModel(vB.getWarnaBarangView().getText());
            mB.setMerekBarangModel(vB.getMerekBarangView().getText());
            stok = (int) vB.getStokBarangView().getValue();
            if( stok != 0 ){
                mB.setStokBarangModel(stok);
            }else{
                mB.setStokBarangModel(0);
            }

            mB.setHargaBarangModel(Integer.parseInt(vB.getHargaBarangView().getText()));
            
            mB.UpdateDataBarang();
            bersihkan();
            kontrolButton();
        }
        public void hapus(){
            mB = new modelBarang();
            
            mB.setKodeBarangModel(Integer.parseInt(vB.getKodeBarangView().getText()));
            
            mB.HapusDataBarang();
            bersihkan();
            kontrolButton();
        }
        
        public void kontrolButton(){
            vB.getTombolSimpan().setEnabled(true);
            vB.getTombolEdit().setEnabled(false);
            vB.getTombolHapus().setEnabled(false);
            vB.getTombolBatal().setEnabled(true);
        }
        
        public void kontrolButton2(){
            vB.getTombolSimpan().setEnabled(false);
            vB.getTombolEdit().setEnabled(true);
            vB.getTombolHapus().setEnabled(true);
            vB.getTombolBatal().setEnabled(true);
        }
}

