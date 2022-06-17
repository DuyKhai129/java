/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package focusdemo;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author duykhai
 */
public class FocusDemo extends JFrame implements FocusListener {
    JTextField vl1,vl2,sum;
    JLabel plus ,equals;
    public FocusDemo(){
        super("Thêm hai số:");
        setSize(400,95);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout FLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(FLayout);
        vl1 =  new JTextField("0", 5);
        plus = new  JLabel("+");
        vl2 =  new JTextField("0", 5);
        equals = new  JLabel("=");
        sum = new JTextField("0", 5);
        
        vl1.addFocusListener(this);
        vl2.addFocusListener(this);
        
        sum.setEditable(false);
        
        add(vl1);
        add(plus);
        add(vl2);
        add(equals);
        add(sum);
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FocusDemo frame = new FocusDemo();
    }

    @Override
    public void focusGained(FocusEvent e) {
         try {
      float total = Float.parseFloat(vl1.getText())
          + Float.parseFloat(vl2.getText());
      sum.setText("" + total);
    } catch (NumberFormatException nfe) {
      vl1.setText("0");
      vl2.setText("0");
      sum.setText("0");
    }
    }

    @Override
    public void focusLost(FocusEvent e) {
         focusGained(e);
    }
    
}
