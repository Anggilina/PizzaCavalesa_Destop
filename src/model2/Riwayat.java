package model2;

public class Riwayat {
    private String pesan_Id;
    private String customer_Id;
    private String customer_Nama;
    private String tanggal;
    private String pizza_Nama;
    private int jumlah;
    private int harga;
    private int total;

    public Riwayat(String pesan_Id, String customer_Id, String customer_Nama, String tanggal,String pizza_Nama, int jumlah, int harga,int total) {
        this.pesan_Id = pesan_Id;
        this.customer_Id = customer_Id;
        this.customer_Nama = customer_Nama;
        this.tanggal = tanggal;
        this.pizza_Nama= pizza_Nama;
        this.jumlah = jumlah;
        this.harga=harga;
        this.total=total;
    }

    public String getPesan_Id() {
        return pesan_Id;
    }

    public void setPesan_Id(String pesan_Id) {
        this.pesan_Id = pesan_Id;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getCustomer_Nama() {
        return customer_Nama;
    }

    public void setCustomer_Nama(String customer_Nama) {
        this.customer_Nama = customer_Nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPizza_Nama() {
        return pizza_Nama;
    }

    public void setPizza_Nama(String pizza_Nama) {
        this.pizza_Nama= pizza_Nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public int getTotal() {
        return harga;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
