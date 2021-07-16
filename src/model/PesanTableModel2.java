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
public class PesanTableModel2 {
    
    private SimpleStringProperty pesan_id = new SimpleStringProperty("");
    private SimpleStringProperty customer_Id = new SimpleStringProperty("");
    private SimpleStringProperty pizza_id = new SimpleStringProperty("");
    private SimpleIntegerProperty jumlah = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty total = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty diskon = new SimpleIntegerProperty(0);
    private SimpleStringProperty tanggal = new SimpleStringProperty("");
    private SimpleStringProperty tambahan = new SimpleStringProperty("");
    
    public PesanTableModel2() {
    }
    
    public String getPesan_ID() {
        return pesan_id.get();
    }

    public void setPesan_ID(String pesan_id) {
        this.pesan_id.set(pesan_id);
    }
    
    public String getCustomer_Id() {
        return customer_Id.get();
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id.set(customer_Id);
    }
    
    public String getPizza_Id() {
        return pizza_id.get();
    }

    public void setPizza_Id(String pizza_id) {
        this.pizza_id.set(pizza_id);
    }
    
    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }
    
    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }
    
    public int getTotal() {
        return total.get();
    }

    public void setTotal(int total) {
        this.total.set(total);
    }
    
    public int getDiskon() {
        return diskon.get();
    }

    public void setDiskon(int diskon) {
        this.diskon.set(diskon);
    }
    
    public String getTambahan() {
        return tambahan.get();
    }

    public void setTambahan(String tambahan) {
        this.tambahan.set(tambahan);
    }
}

