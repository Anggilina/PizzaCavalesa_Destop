/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author user
 */
public class PesanTableModel{
   
    private SimpleStringProperty pizza_Id = new SimpleStringProperty("");
    private SimpleStringProperty pizza_Nama = new SimpleStringProperty("");
    private SimpleIntegerProperty harga = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty jumlah = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty SubJumlah = new SimpleIntegerProperty(0);

    
    public PesanTableModel() {
    }
    
   
    
    public String getPizza_Id() {
        return pizza_Id.get();
    }

    public void setPizza_Id(String pizza_id) {
        this.pizza_Id.set(pizza_id);
    }
    
    public String getPizza_Nama() {
        return pizza_Nama.get();
    }

    public void setPizza_Nama(String pizza_Nama) {
        this.pizza_Nama.set(pizza_Nama);
    }
    
     public int getHarga() {
        return harga.get();
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }
    
    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }
    
    public int getSubJumlah() {
        return SubJumlah.get();
    }

    public void setSubJumlah(int SubJumlah) {
        this.SubJumlah.set(SubJumlah);
    }
   
}
