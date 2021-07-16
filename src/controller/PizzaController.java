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
import koneksi.Koneksi2;
import model2.Pizza;

/**
 *
 * @author user
 */
public class PizzaController {

    public static ArrayList<Pizza> getAllItem() throws ClassNotFoundException, SQLException {
        Connection conn = Koneksi2.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From pizza");
        ArrayList<Pizza> itemList = new ArrayList<>();
        while (rst.next()) {
            Pizza pizza;
            pizza = new Pizza(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5));
            itemList.add(pizza);
        }
        return itemList;
    }

    public static Pizza searchItem(String pizza_id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM pizza WHERE pizza_id = ? ";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, pizza_id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            Pizza c = new Pizza(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5));
            return c;
        }
        return null;
    }

    public static int updateItem(Pizza pizza) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE pizza SET pizza_id=? ,pizza_nama=? ,harga=? ,descripsi=? ,tipe_pizza=? , WHERE pizza_id=? ";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, pizza.getPizza_Id());
        stm.setObject(2, pizza.getPizza_Nama());
        stm.setObject(3, pizza.getHarga());
        stm.setObject(4, pizza.getDescripsi());
        stm.setObject(5, pizza.getTipe_Pizza());
        
        return stm.executeUpdate();
    }

    public static int deleteItem(String pizza_id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM pizza WHERE pizza_id='" + pizza_id + "'";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();

    }

    public static int addItem(Pizza pizza) throws ClassNotFoundException, SQLException {
        String sql = "Insert into pizza values(?,?,?,?,?)";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, pizza.getPizza_Id());
        stm.setObject(2, pizza.getPizza_Nama());
        stm.setObject(3, pizza.getHarga());
        stm.setObject(4, pizza.getDescripsi());
        stm.setObject(5, pizza.getTipe_Pizza());

        return stm.executeUpdate();

    }
}
