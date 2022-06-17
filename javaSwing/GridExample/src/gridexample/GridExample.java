/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gridexample;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class GridExample extends JFrame{
    Button red;
    public GridExample(String tile)
    {super(tile);
     this.setLayout(new GridLayout(5,2,20,10));
     red=new Button("Red");
     this.add(red);
     this.add(new Button("Blue"));
     this.add(new Button("Green"));
     this.add(new Checkbox("Pick me",true));
     this.add(new Label("Enter name here: "));
     this.add(new TextField(10));
     this.add(new Label("Them"));
     ///this.pack();
     this.setSize(400,300);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        new GridExample("Grid Dempo");
    }
    
}

