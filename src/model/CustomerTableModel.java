/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class CustomerTableModel {

    private SimpleStringProperty customer_Id = new SimpleStringProperty("");
    private SimpleStringProperty customer_Nama = new SimpleStringProperty("");
    private SimpleIntegerProperty Tpno = new SimpleIntegerProperty(0);
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty alamat = new SimpleStringProperty("");
    

    public CustomerTableModel() {
    }

    public String getCustomer_Id() {
        return customer_Id.get();
    }

    public String getCustomer_Nama() {
        return customer_Nama.get();
    }

    public int getTpNo(){
        return Tpno.get();
    }
    
    public String getEmail() {
        return email.get();
    }
    public String getAlamat() {
        return alamat.get();
    }

   

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id.set(customer_Id);
    }

    public void setCustomer_Nama(String customer_Nama) {
        this.customer_Nama.set(customer_Nama);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    
    public void setTpNo(int Tpno) {
        this.Tpno.set(Tpno);
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    
}
