/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

/**
 *
 * @author user
 */
public class Pizza {
    private String pizza_Id;
    private String pizza_Nama;
    private int harga;
    private String Descripsi;
    private String tipe_Pizza;
    
    public Pizza() {
    }
    
    public Pizza(String pizza_Id,String pizza_Nama,int harga,String Descripsi,String tipe_Pizza) {
        this.pizza_Id=pizza_Id;
        this.pizza_Nama=pizza_Nama;
        this.harga=harga;
        this.Descripsi=Descripsi;
        this.tipe_Pizza=tipe_Pizza;
        
    }
    
    public String getPizza_Id() {
        return pizza_Id;
    }

    public void setPizza_Id(String pizza_Id) {
        this.pizza_Id=pizza_Id;
    }
    
    public String getPizza_Nama() {
        return pizza_Nama;
    }

    public void setPizza_Nama(String pizza_Nama) {
        this.pizza_Nama=pizza_Nama;
    }
    
    public String getDescripsi() {
        return Descripsi;
    }

    public void setDescripsi(String Descripsi) {
        this.Descripsi=Descripsi;
    }
    
    public int getHarga() {
        return harga;
    }

    public void setHarga(int Harga) {
        this.harga=harga;
    }
    
    public String getTipe_Pizza() {
        return tipe_Pizza;
    }

    public void setTipe_Pizza(String tipe_Pizza) {
        this.tipe_Pizza=tipe_Pizza;
    }
    
    
}
