/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author JUNITA
 */
public class itemtransaksi {

        private double harga;
    
    private int jumlah;
    
    private int id_obat;

    public long getid_obat() {
        return id_obat;
    }

    public void setid_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getjumlah() {
        return jumlah;
    }

    public void setjumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
