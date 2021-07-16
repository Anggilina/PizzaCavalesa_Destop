/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import koneksi.Koneksi;
import koneksi.Koneksi2;
import model2.Pesan;
import model2.PesanDetail;
import model2.Pizza;
import model2.Riwayat;

/**
 *
 * @author user
 */
public class PesanController {
    
    public static boolean addNewOrder(Pesan orders)throws ClassNotFoundException, SQLException{
        Connection conn=Koneksi2.getDBConnection().getConnection();
        String SQL="Insert into pesan Values(?,?,?)";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,orders.getPesan_ID());
        stm.setObject(2,orders.getCustomer_Id());
        stm.setObject(3,orders.getTanggal());
        int res=stm.executeUpdate();
        if(res>0){
            boolean isAdded=PesanDetailController.addOrderDetails(orders.getOrder_DetailList());
            if(isAdded){
                return true;
            }
        }
        return false;
    }
    
 
    
    public static ArrayList<Riwayat> getAllOrders() throws SQLException, ClassNotFoundException {
        String SQL="SELECT ps.pesan_id,ps.customer_id,c.customer_nama,ps.tanggal,p.pizza_nama,pd.jumlah,pd.harga,pd.jumlah*pd.harga AS Total\n" +
                "FROM pesan ps,customer c,pesandetail pd, pizza p\n" +
                "WHERE ps.customer_id=c.customer_id && ps.pesan_id=pd.pesan_id && p.pizza_id=pd.pizza_id;";
        Connection conn= Koneksi2.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<Riwayat> allOrders=new ArrayList<>();
        while (rst.next()){
            Riwayat allOrder;
            allOrder=new Riwayat(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7),rst.getInt(8));
            allOrders.add(allOrder);
        }
        return allOrders;
    }
    
    
    public static ArrayList<Riwayat> getAllOrdersDate(String date) throws SQLException, ClassNotFoundException {
        String SQL="SELECT ps.pesan_id,ps.customer_id,c.customer_nama,ps.tanggal,p.pizza_nama,pd.jumlah,pd.harga,pd.jumlah*pd.harga AS Total\n" +
                "FROM pesan ps,customer c,pesandetail pd, pizza p\n" +
                "WHERE ps.customer_id=c.customer_id && ps.pesan_id=pd.pesan_id && p.pizza_id=pd.pizza_id && ps.tanggal='"+date+"'";
        Connection conn= Koneksi2.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<Riwayat> allOrders=new ArrayList<>();
        while (rst.next()){
            Riwayat allOrder;
            allOrder=new Riwayat(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7),rst.getInt(8));
            allOrders.add(allOrder);
        }
        return allOrders;
    }

}
