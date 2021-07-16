/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Koneksi2 {
    private Connection conn;
	private static Koneksi2 dbConnection;
	private Koneksi2()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/pizzacava","root","");
		}
	public Connection getConnection(){
		return conn;
	}
	public static Koneksi2 getDBConnection()throws ClassNotFoundException,SQLException{
		if(dbConnection==null){
			dbConnection=new Koneksi2();
		}
		return dbConnection;
	}
}
