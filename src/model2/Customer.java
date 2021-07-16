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
public class Customer {
    private String customer_Id;
    private String customer_Nama;
    private String email;
    private int TpNo;
    private String alamat;
            
     public Customer() {
    }
    
    public Customer(String customer_Id, String customer_Nama,int TpNo,String email, String alamat) {
        this.customer_Id = customer_Id;
        this.customer_Nama = customer_Nama;
        this.TpNo = TpNo;
        this.email=email;
        this.alamat = alamat;
    }
    
    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id=customer_Id;
    }
    
    public String getCustomer_Nama() {
        return customer_Nama;
    }

    public void setCustomer_Nama(String customer_Nama) {
        this.customer_Nama=customer_Nama;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public int getTpNo() {
        return TpNo;
    }

    public void setTpNo(int TpNo){
        this.TpNo=TpNo;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat=alamat;
    }
}
