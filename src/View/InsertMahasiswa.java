/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.Jurusan;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aspire
 */
public class InsertMahasiswa extends JFrame implements ActionListener{
    JFrame frame_maba;
    JLabel label_nim,label_nama,label_angkatan, label_jurusan,label_atas;
    JTextField tfNim,tfNama,tfAngkatan;
    JButton buttonSubmit,buttonBack,buttonReset;
    JComboBox CBJurusan;
    String[] jurusan;
    public InsertMahasiswa(){
        frame_maba = new JFrame("Insert Data Mahasiswa Baru");
        frame_maba.setSize(400, 500);
        frame_maba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_maba.setLocationRelativeTo(null);
        
        label_atas = new JLabel("Silahkan Insert Data Dibawah ");
        label_atas.setBounds(100, 10, 200, 30);
        
        label_nim = new JLabel("NIM ");
        label_nim.setBounds(45, 50, 100, 30);
        
        tfNim = new JTextField();
        tfNim.setBounds(150, 50, 200, 30);
        
        label_nama = new JLabel("Nama ");
        label_nama.setBounds(45, 100, 100, 30);
        
        tfNama = new JTextField();
        tfNama.setBounds(150, 100, 200, 30);
        
        label_angkatan = new JLabel("Angkatan ");
        label_angkatan.setBounds(45, 150, 100, 30);
        
        tfAngkatan = new JTextField();
        tfAngkatan.setBounds(150, 150, 200, 30);
        
        ArrayList<Jurusan> listJur = Controller.getAllJurusan();
        int panjang = listJur.size();
        jurusan = new String[panjang];
        for(int i = 0; i < listJur.size() ; i++){
            jurusan[i] = listJur.get(i).getKode();
        }
        
        label_jurusan = new JLabel("Jurusan ");
        label_jurusan.setBounds(45, 200, 100, 30);
        
        CBJurusan = new JComboBox(jurusan);
        CBJurusan.setBounds(150, 200, 200, 30); 
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(45,250,300,30);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(50,300,100,30);
        buttonBack.addActionListener(this);
        
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(250,300,100,30);
        buttonReset.addActionListener(this);
          
        frame_maba.add(CBJurusan);
        frame_maba.add(label_atas);
        frame_maba.add(buttonReset);
        frame_maba.add(buttonBack);
        frame_maba.add(buttonSubmit);
        frame_maba.add(tfNim);
        frame_maba.add(label_nama);
        frame_maba.add(label_nim);
        frame_maba.add(tfNama);
        frame_maba.add(label_angkatan);
        frame_maba.add(tfAngkatan);
        frame_maba.add(label_jurusan);
        frame_maba.setLayout(null);
        frame_maba.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String nama = tfNama.getText();
                String nim = tfNim.getText();
                int angkatan = Integer.parseInt(tfAngkatan.getText());
                if(nama.equals("") && nim.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                else {
                    String jurusan = CBJurusan.getItemAt(CBJurusan.getSelectedIndex()).toString();
                    if(Controller.insertMABA(nim, nama, angkatan, jurusan)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        frame_maba.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                frame_maba.setVisible(false);
                new MainMenu();
                break;
            case"Reset":
                frame_maba.setVisible(false);
                new InsertMahasiswa();
                break;
            default:
                break;
        }
    }
}
