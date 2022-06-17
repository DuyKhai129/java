/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vidu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class Vidu extends JFrame {
    Button nut1;
    public Vidu (String title ) throws HeadlessException{
        super(title);
        nut1 =new Button("Nút OK");
        TaiButton tail = new TaiButton();
        nut1.addActionListener(tail);
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(nut1);
        this.setLayout(new BorderLayout());
        this.add(p1,BorderLayout.NORTH);
        Label nhan2 = new Label("Mouse click");
        this.add(nhan2,BorderLayout.CENTER);
        this.setBounds(300,300,300,200);
        this.setVisible(true);
        
    }
    /**
     * @param args the command line arguments
     */
    class TaiButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            System.out.println("đẹp trai vô bơ bến");
        }
        
            }
    public static void main(String[] args) {
        // TODO code application logic here
        Vidu vidu = new Vidu ("vidu 1");
    }
    
}
