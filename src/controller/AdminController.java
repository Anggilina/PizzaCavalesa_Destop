package controller;

import koneksi.Koneksi2;
import koneksi.Koneksi;
import model2.Admin;

import java.sql.*;
import java.util.ArrayList;


public class AdminController {

    public static int addUser(Admin users) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO admin VALUES(?,?,?,?)";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, users.getUser_Name());
        stm.setObject(2, users.getUser_Password());
        stm.setObject(3, users.getUser_Email());
        stm.setObject(4, users.getUser_Type());

        return stm.executeUpdate();
    }

    public static Admin searchUser(String user_Name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM admin WHERE username = ? ";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user_Name);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            Admin u = new Admin(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            return u;
        }
        return null;
    }

    public static int updateUser(Admin users) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE admin SET username= ? ,password= ? email=?, type= ? WHERE username= ? ";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, users.getUser_Name());
        stm.setObject(2, users.getUser_Password());
        stm.setObject(3, users.getUser_Email());
        stm.setObject(4, users.getUser_Type());

        return stm.executeUpdate();
    }

    public static int deleteUser(String user_Name) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM admin WHERE username='" + user_Name + "'";
        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();

    }

    public static ArrayList<Admin> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection conn = Koneksi2.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From admin");
        ArrayList<Admin> userList = new ArrayList<>();
        while (rst.next()) {
            Admin users;
            users = new Admin(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            userList.add(users);
        }
        return userList;
    }

    public static boolean Login(String userName, String password) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM admin WHERE username=?";

        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, userName);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            if (!rst.getString(1).equals(userName)) {
                return false;
            }
            String pwd = rst.getString(2);
            if (pwd.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean AccountType(String userName) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM admin WHERE username=?";
        String LType = "admin";

        Connection conn = Koneksi2.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, userName);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            String type = rst.getString(4);
            if (type.equals(LType)) {
                return true;
            }
        }
        return false;
    }
}
