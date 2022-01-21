/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author 
 */
public class koneksiDatabase {
    private static Connection conn;
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
       if(conn == null){
           try {
               propert.load(new FileInputStream("D:\\UNSIKA\\SEMESTER 5\\PEMROGRAMAN BERBASIS DEKSTOP\\byrcloth\\src\\database\\konfigurasiDatabase.properties"));
               
           } catch(IOException ex){
               System.err.println("error mengambil file"+ex);
           }
           
                conn = (Connection) DriverManager.getConnection(propert.getProperty("jdbc.url"),
                        propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
       }
       return conn;
    }
    
}
