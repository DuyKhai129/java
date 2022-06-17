/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flowexample;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class FlowExample extends JFrame{
    Button btnred;
    public FlowExample() {
//        FlowLayout dongchay = new FlowLayout(FlowLayout.CENTER, 10, 20);
//        this.setLayout(dongchay);
       this.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
       // this.setLayout(new FlowLayout(FlowLayout.LEFT));
        System.out.println("Right  " + FlowLayout.RIGHT);      
        this.add(btnred = new Button("Red"));
        this.add(new Button("Blue"));
        this.add(new Button("Green"));
        List li = new List();
        li.add("Mot");
        li.add("Hai");
        li.add("Ba");
        this.add(li);
        this.add(new Checkbox("Pick me", true));
        this.add(new Label("Enter your name: "));
        this.add(new TextField(20));
       // this.pack();
        this.setBounds(100, 100, 400, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new FlowExample();
    }
    
}
