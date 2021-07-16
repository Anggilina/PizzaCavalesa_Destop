/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.sql.Date;
import java.util.ArrayList;
import model2.PesanDetail;

/**
 *
 * @author user
 */
public class Pesan {
    private String pesan_id;
    private String customer_Id ;
    private String tanggal;
    private ArrayList order_DetailList;
    
    public Pesan() {
    }
    
    public Pesan(String pesan_id,String customer_Id,String tanggal, ArrayList<PesanDetail> orderDetailList) {
        this.pesan_id=pesan_id;
        this.customer_Id=customer_Id;
        this.tanggal=tanggal;
        this.order_DetailList=orderDetailList;
    }
    
    public String getPesan_ID() {
        return pesan_id;
    }

    public void setPesan_ID(String pesan_id) {
        this.pesan_id=pesan_id;
    }
    
    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id=customer_Id;
    }
    
    /*public String getPizza_Id() {
        return pizza_id;
    }

    public void setPizza_Id(String pizza_id) {
        this.pizza_id=pizza_id;
    }*/
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal=tanggal;
    }
    
    /*public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah=jumlah;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total=total;
    }
    
    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon=diskon;
    }*/
    
    public ArrayList getOrder_DetailList() {
        return order_DetailList;
    }

    public void setOrder_DetailList(ArrayList order_DetailList) {
        this.order_DetailList = order_DetailList;
    }
    
    
}
