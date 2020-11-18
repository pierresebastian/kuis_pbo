/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 *
 * @author Aspire
 */ 
public class MainMenu extends JFrame implements ActionListener{
    JFrame frame;
    JButton buttonInsertJurusan;
    JButton buttonLihatJurusan;
    JButton buttonInsertMahasiswa;
    JButton buttonLihatMahasiswa;
    JButton buttonExit;
        
    public MainMenu(){
        frame = new JFrame("MyITHB");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        buttonInsertJurusan = new JButton("Insert Data Jurusan Baru");
        buttonInsertJurusan.setBounds(90, 90, 200, 50);
        buttonInsertJurusan.addActionListener(this);
        buttonLihatJurusan = new JButton("Lihat Data Jurusan Baru");
        buttonLihatJurusan.setBounds(90, 150, 200, 50);
        buttonLihatJurusan.addActionListener(this);
        buttonInsertMahasiswa = new JButton("Insert Data Mahasiswa Baru");
        buttonInsertMahasiswa.setBounds(90, 210, 200, 50);
        buttonInsertMahasiswa.addActionListener(this);
        buttonLihatMahasiswa = new JButton("Lihat Data Mahasiswa Baru");
        buttonLihatMahasiswa.setBounds(90, 270, 200, 50);
        buttonLihatMahasiswa.addActionListener(this);
        buttonExit = new JButton("Exit");
        buttonExit.setBounds(140, 330, 100, 50);
        buttonExit.addActionListener(this);
        
        frame.add(buttonExit);
        frame.add(buttonInsertJurusan);
        frame.add(buttonLihatJurusan);
        frame.add(buttonInsertMahasiswa);
        frame.add(buttonLihatMahasiswa);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Insert Data Jurusan Baru":
                frame.setVisible(false);
                new InsertJurusan();
                break;
            case "Lihat Data Jurusan Baru":
                frame.setVisible(false);
                new LihatJurusan();
                break;
             case "Insert Data Mahasiswa Baru":
                frame.setVisible(false);
                new InsertMahasiswa();
                break;
              case "Lihat Data Mahasiswa Baru":
                frame.setVisible(false);
                new LihatMahasiswa();
                break;
            case "Exit": 
                System.exit(0);
                break;
        }
    }
}
