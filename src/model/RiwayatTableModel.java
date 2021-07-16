package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class RiwayatTableModel {

    private SimpleStringProperty pesan_Id=new SimpleStringProperty("");
    private SimpleStringProperty customer_Id=new SimpleStringProperty("");
    private SimpleStringProperty customer_Nama=new SimpleStringProperty("");
    private SimpleStringProperty tanggal=new SimpleStringProperty("");
    private SimpleStringProperty pizza_Nama=new SimpleStringProperty("");
    private SimpleIntegerProperty jumlah=new SimpleIntegerProperty(0);
    private SimpleIntegerProperty harga=new SimpleIntegerProperty(0);
    private SimpleIntegerProperty total=new SimpleIntegerProperty(0);
   

    public RiwayatTableModel(SimpleStringProperty pesan_Id, SimpleStringProperty customer_Id, SimpleStringProperty customer_Nama, SimpleStringProperty tanggal,SimpleStringProperty pizza_Nama,SimpleIntegerProperty jumlah,SimpleIntegerProperty harga,SimpleIntegerProperty total) {
        this.pesan_Id = pesan_Id;
        this.customer_Id = customer_Id;
        this.customer_Nama = customer_Nama;
        this.tanggal = tanggal;
        this.pizza_Nama = pizza_Nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total=total;
    }

    public RiwayatTableModel() {

    }

    public String getPesan_Id() {
        return pesan_Id.get();
    }

    public SimpleStringProperty Pesan_Id() {
        return pesan_Id;
    }

    public void setPesan_Id(String pesan_Id) {
        this.pesan_Id.set(pesan_Id);
    }

    public String getCustomer_Id() {
        return customer_Id.get();
    }

    public SimpleStringProperty customer_IdProperty() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id.set(customer_Id);
    }

    public String getCustomer_Nama() {
        return customer_Nama.get();
    }

    public SimpleStringProperty customer_NamaProperty() {
        return customer_Nama;
    }

    public void setCustomer_Nama(String customer_Nama) {
        this.customer_Nama.set(customer_Nama);
    }

    public String getTanggal() {
        return tanggal.get();
    }

    public SimpleStringProperty Tanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public String getPizza_Nama() {
        return pizza_Nama.get();
    }

    public SimpleStringProperty Pizza_Nama() {
        return pizza_Nama;
    }

    public void setPizza_Nama(String pizza_Nama) {
        this.pizza_Nama.set(pizza_Nama);
    }
    
    public int getJumlah() {
        return jumlah.get();
    }

    public SimpleIntegerProperty Jumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }
    
    public int getHarga() {
        return harga.get();
    }

    public SimpleIntegerProperty Harga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }
    
    public int getTotal() {
        return total.get();
    }

    public SimpleIntegerProperty Total() {
        return total;
    }

    public void setTotal(int total) {
        this.total.set(total);
    }
}
