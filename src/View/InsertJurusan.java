/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Jurusan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author Aspire
 */
public class InsertJurusan extends JFrame implements ActionListener{
    JFrame frame_jurusan;
    JLabel label_kode,label_nama,label_atas;
    JTextField tfKode,tfNama;
    JButton buttonSubmit,buttonBack,buttonReset;
    public InsertJurusan(){
        frame_jurusan = new JFrame("Insert Jurusan");
        frame_jurusan.setSize(400, 300);
        frame_jurusan.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_jurusan.setLocationRelativeTo(null);
        
        label_atas = new JLabel("Silahkan Insert Data Dibawah ");
        label_atas.setBounds(100, 10, 200, 30);
        
        label_kode = new JLabel("Kode ");
        label_kode.setBounds(45, 50, 100, 30);
        
        tfKode = new JTextField();
        tfKode.setBounds(150, 50, 200, 30);
        
        label_nama = new JLabel("Nama ");
        label_nama.setBounds(45, 100, 100, 30);
        
        tfNama = new JTextField();
        tfNama.setBounds(150, 100, 200, 30);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(45,150,300,30);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(50,200,100,30);
        buttonBack.addActionListener(this);
        
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(250,200,100,30);
        buttonReset.addActionListener(this);
           
        frame_jurusan.add(label_atas);
        frame_jurusan.add(buttonReset);
        frame_jurusan.add(buttonBack);
        frame_jurusan.add(buttonSubmit);
        frame_jurusan.add(tfKode);
        frame_jurusan.add(label_nama);
        frame_jurusan.add(label_kode);
        frame_jurusan.add(tfNama);
        frame_jurusan.setLayout(null);
        frame_jurusan.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String kodeJurusan = tfKode.getText();
                String namaJurusan = tfNama.getText();
                ArrayList<Jurusan> listJur = Controller.getAllJurusan();
            
                if(kodeJurusan.equals("") && namaJurusan.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.insertJurusan(kodeJurusan, namaJurusan)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        frame_jurusan.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                frame_jurusan.setVisible(false);
                new MainMenu();
                break;
            case"Reset": 
                frame_jurusan.setVisible(false);
                new InsertJurusan();
                break;
            default:
                break;
        }
    }
    
}
