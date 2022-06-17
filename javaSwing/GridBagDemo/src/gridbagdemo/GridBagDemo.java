/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gridbagdemo;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class GridBagDemo extends JFrame {

    GridBagDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        
        GridBagConstraints myContraints = new GridBagConstraints();
        for (int y = 1; y <= 3; y++) {
            for (int x = 1; x <= 4; x++) {
                myContraints.gridx = x;
                myContraints.gridy = y;
                String text = "Button(" + x + ", " + y + ")";
                contentPane.add(new Button(text), myContraints);
            }
        }
        this.pack();
        //this.setBounds(50,50,100,100);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        new GridBagDemo();
    }

}
