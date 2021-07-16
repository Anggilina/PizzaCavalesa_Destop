/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;



public class PesanDetail {
    private String pesan_Id;
    private String item_Code;
    private int item_Qty;
    private int item_UnitPrice;
    

    public PesanDetail() {
    }

    public PesanDetail(String pesan_Id, String item_Code, int item_Qty, int item_UnitPrice) {
        this.pesan_Id = pesan_Id;
        this.item_Code = item_Code;
        this.item_Qty = item_Qty;
        this.item_UnitPrice = item_UnitPrice;
    }

    /**
     * @return the order_Id
     */
    public String getPesan_ID() {
        return pesan_Id;
    }

    public void setPesan_ID(String pesan_Id) {
        this.pesan_Id=pesan_Id;
    }

    /*public String getCustomer_Id() {
        return customer_id;
    }

    public void setCustomer_Id(String customer_id) {
        this.customer_id=customer_id;
    }*/

    
    public String getItem_Code() {
        return item_Code;
    }

    public void setItem_Code(String item_Code) {
        this.item_Code = item_Code;
    }

    /**
     * @return the item_Qty
     */
    public int getItem_Qty() {
        return item_Qty;
    }

    /**
     * @param item_Qty the item_Qty to set
     */
    public void setItem_Qty(int item_Qty) {
        this.item_Qty = item_Qty;
    }

    /**
     * @return the item_UnitPrice
     */
    public int getItem_UnitPrice() {
        return item_UnitPrice;
    }

    /**
     * @param item_UnitPrice the item_UnitPrice to set
     */
    public void setItem_UnitPrice(int item_UnitPrice) {
        this.item_UnitPrice = item_UnitPrice;
    }
    
    /*public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon=diskon;
    }*/
    
    /*public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal=tanggal;
    }*/
    
    
    
    
}
