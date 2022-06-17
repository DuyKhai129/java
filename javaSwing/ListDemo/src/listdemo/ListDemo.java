/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listdemo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author duykhai
 */

public class ListDemo extends Frame implements  ItemListener {

   private List colorList;    
    ListDemo(String tile) {
        super(tile);
        colorList = new List(5, false);
        colorList.add("White");
        colorList.add("Green");
        colorList.add("Yellow");
         colorList.add("Magenta");
        colorList.add("Balck");
        colorList.add("Blue");
        colorList.add("Pink");
       colorList.select(5);
       this.setBackground(Color.PINK);      
        colorList.addItemListener(this);
        this.setLayout(new FlowLayout());
        this.add(colorList);
        this.setBounds(55, 55, 405, 305);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }    
    public static void main(String[] args) {
       new ListDemo("Demo List");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String select = colorList.getSelectedItem();
        
        if (select.equalsIgnoreCase("White")) {
            this.setBackground(Color.WHITE);
        }
        if (select.equalsIgnoreCase("Balck")) {
            this.setBackground(Color.BLACK);
        }
        if (select.equalsIgnoreCase("Yellow")) {
            this.setBackground(Color.YELLOW);
        }
         if (select.equalsIgnoreCase("Magenta")) {
            this.setBackground(Color.magenta);
        }
        if (select.equalsIgnoreCase("Green")) {
            this.setBackground(Color.GREEN);
        }
        if (select.equalsIgnoreCase("Pink")) {
            this.setBackground(Color.PINK);
        }
        if (select.equalsIgnoreCase("blue")) {
            this.setBackground(Color.BLUE);
        }
        this.repaint();
    }
    
}
