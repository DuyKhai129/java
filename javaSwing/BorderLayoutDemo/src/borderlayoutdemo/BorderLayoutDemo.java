/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package borderlayoutdemo;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class BorderLayoutDemo extends JFrame{
    JButton nut1;
    public static void main(String args[]) {
       new  BorderLayoutDemo();
    }
    public  BorderLayoutDemo() {
        super("Demo BorderLayout");
        this.setLayout(new BorderLayout());
        nut1=new JButton("North");
       this.add(nut1, BorderLayout.NORTH);
      this.add(new Button("South"), BorderLayout.SOUTH);
       this.add(new Button("East"), BorderLayout.EAST);
        this.add(new Button("West"), BorderLayout.WEST);
        this.add("Center", new Button("Click"));
    
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(400,300);
    
        this.setVisible(true);
    }
    
}
