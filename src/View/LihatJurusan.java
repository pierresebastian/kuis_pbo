/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.Jurusan;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Aspire 
 */
public class LihatJurusan extends JFrame implements ActionListener{
    JFrame frameJurusan;
    String[][] data;
    String[] kolom = {"Kode","Nama"};
    JLabel label_kode,label_jurusan;
    JTable tabelJurusan;
    String kodeJurusan = "";
    String namaJurusan = "";
    public LihatJurusan(){
        frameJurusan = new JFrame("Jurusan");
        frameJurusan.setSize(500, 500);
        frameJurusan.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameJurusan.setLocationRelativeTo(null);
        
        ArrayList<Jurusan> listJurusan = Controller.getAllJurusan();
         int panjang = listJurusan.size();
         data = new String[panjang][2];
         for(int i = 0; i < listJurusan.size() ; i++){
                data[i][0] = listJurusan.get(i).getKode();
              data[i][1] = listJurusan.get(i).getNama();
        }
        
        tabelJurusan = new JTable(data,kolom);
        tabelJurusan.setBounds(20, 20, 200, 500);
        frameJurusan.add(tabelJurusan);
        frameJurusan.setLayout(null);
        frameJurusan.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
