/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gridlayoutdemo;

import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class GridLayoutDemo extends JFrame {

    public GridLayoutDemo(String tile) {
        this.setLayout(new GridLayout(3, 0, 10, 20));
        for (int i = 1; i <= 10; i++) {
            this.add(new Button("Button " + i));
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 500, 300);
        this.setVisible(true);
    }
    public static void main(String args[]) {
        new GridLayoutDemo("cong");
    }

}
