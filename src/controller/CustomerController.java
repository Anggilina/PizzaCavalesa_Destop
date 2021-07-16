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
import model2.Customer;

/**
 *
 * @author user
 */
public class CustomerController {
    public static int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "Insert into customer values(?,?,?,?,?)";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer.getCustomer_Id());
        stm.setObject(2, customer.getCustomer_Nama());
        stm.setObject(3, customer.getTpNo());
        stm.setObject(4, customer.getEmail());
        stm.setObject(5, customer.getAlamat());
        return  stm.executeUpdate();
        
    }

    public static ObservableList<Customer> searchCustomer (String id) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        ObservableList<Customer> tmpList = FXCollections.observableArrayList();
        Customer temp = null;
        ResultSet rs = null;
        String selectStmt = "SELECT * FROM customer WHERE customer_id='"+id+"'";

        try {
            rs= Koneksi.dbExecuteQuery(selectStmt);
            
            while (rs.next()) {

                temp = new Customer();

                temp.setCustomer_Id(rs.getString("customer_id"));
                temp.setCustomer_Nama(rs.getString("customer_nama"));
                temp.setEmail(rs.getString("email"));
                temp.setTpNo(rs.getInt("Tpno"));
                temp.setAlamat(rs.getString("alamat"));
                
                tmpList.add(temp);
            }

            //Return employee object
            return tmpList;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + id + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
    
    public static Customer searchCustomer2(String customer_Id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer WHERE customer_id = ? ";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer_Id);
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            Customer c=new Customer(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            return c;
        }
        return null;
    }

    public static int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE customer SET customer_id= ?, customer_nama= ?,Tpno= ?, email= ?, alamat= ? WHERE customer_id= ? ";    
        Connection conn = Koneksi2.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setObject(1, customer.getCustomer_Id());
            stm.setObject(2, customer.getCustomer_Nama());
            stm.setObject(3, customer.getEmail());
            stm.setObject(4, customer.getTpNo());  
            stm.setObject(5, customer.getAlamat());

        return  stm.executeUpdate();
    }
    
    public static int deleteCustomer(String customer_Id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM customer WHERE customer_id='"+customer_Id+"'";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
       return  stm.executeUpdate();
        
    }
    
    
    
    public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException{
        Connection conn=Koneksi2.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rs=stm.executeQuery("Select * From customer");
        ArrayList<Customer>customerList=new ArrayList<>();
        while(rs.next()){
            Customer customer;
            customer = new Customer(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            customerList.add(customer);
            System.out.print(rs.getString(1));
            System.out.print(rs.getString(2));
            System.out.print(rs.getString(3));
            System.out.print(rs.getString(4));
            System.out.print(rs.getString(5));
            
        }
        return customerList;
    }

    
}
