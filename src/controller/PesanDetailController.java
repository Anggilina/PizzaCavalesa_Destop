/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi2;
import model2.PesanDetail;

/**
 *
 * @author user
 */
class PesanDetailController {
    public static boolean addOrderDetails(ArrayList<PesanDetail> orderDetailList)throws ClassNotFoundException, SQLException {
        for(PesanDetail ob : orderDetailList){
            boolean isUpdated=PesanDetailController.addOrderDetails(ob);
            if(!isUpdated){
                return false;
            }
        }
        return true;
    }
    public static boolean addOrderDetails(PesanDetail pesan)throws ClassNotFoundException, SQLException{
        Connection conn= Koneksi2.getDBConnection().getConnection();
        String SQL="Insert into pesandetail(pesan_id,pizza_id,jumlah,harga)Values(?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,pesan.getPesan_ID());
        stm.setObject(2,pesan.getItem_Code());
        stm.setObject(3,pesan.getItem_Qty());
        stm.setObject(4,pesan.getItem_UnitPrice());
        return stm.executeUpdate()>0;
    }
}
