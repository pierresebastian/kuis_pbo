/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jurusan;
import Model.Mahasiswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;

/**
 *
 * @author Aspire
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
   
    public static ArrayList<Jurusan> getAllJurusan() {
        ArrayList<Jurusan> jurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan j = new Jurusan();
                j.setKode(rs.getString("Kode"));
                j.setNama(rs.getString("Nama"));
                jurusan.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jurusan);
    }
    
    //memasukan data jurusan
    public static boolean insertJurusan(String kode, String nama){
        conn.connect();
        String query = "INSERT INTO jurusan VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }

    //Memasukkan data mahasiswa baru
    public static boolean insertMABA(String nim, String nama, int angkatan, String jurusan){
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nim);
            stmt.setString(2, nama);
            stmt.setInt(3, angkatan);
            stmt.setString(4, jurusan);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
}