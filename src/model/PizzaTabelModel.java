/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author user
 */
public class PizzaTabelModel {
    private SimpleStringProperty pizza_Id = new SimpleStringProperty("");
    private SimpleStringProperty pizza_Nama = new SimpleStringProperty("");
    private SimpleIntegerProperty harga = new SimpleIntegerProperty(0);
    private SimpleStringProperty descripsi = new SimpleStringProperty("");
    private SimpleStringProperty tipe_Pizza = new SimpleStringProperty("");
    
    public PizzaTabelModel() {
    }
    
    public String getPizza_Id() {
        return pizza_Id.get();
    }

    public void setPizza_Id(String pizza_Id) {
        this.pizza_Id.set(pizza_Id);
    }
    
    public String getPizza_Nama() {
        return pizza_Nama.get();
    }

    public void setPizza_Nama(String pizza_Nama) {
        this.pizza_Nama.set(pizza_Nama);
    }
    
    public String getDescripsi() {
        return descripsi.get();
    }

    public void setDescripsi(String Descripsi) {
        this.descripsi.set(Descripsi);
    }
    
    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int Harga) {
        this.harga.set(Harga);
    }
    
    public String getTipe_Pizza() {
        return tipe_Pizza.get();
    }

    public void setTipe_Pizza(String tipe_Pizza) {
        this.tipe_Pizza.set(tipe_Pizza);
    }
}
