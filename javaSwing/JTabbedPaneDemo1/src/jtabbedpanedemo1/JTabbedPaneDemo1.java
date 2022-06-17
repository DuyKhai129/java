/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jtabbedpanedemo1;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author duykhai
 */
public class JTabbedPaneDemo1 extends JFrame{
    public static void main(String args[]){
       try{
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
               new JTabbedPaneDemo1();
            }
        });
        }
        catch(Exception e){
                e.printStackTrace();
                }
    }

    public JTabbedPaneDemo1()  {
        this.add(new JTabbedPaneDemo());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 300, 500, 500);
        this.setVisible(true);
    }
    
     
    
}
class JTabbedPaneDemo extends JPanel {

   public JTabbedPaneDemo() {
      
               makeGUI();
         
   }
   
   private void makeGUI() {

      JTabbedPane jtp = new JTabbedPane();
      jtp.addTab("Cities", new CitiesPanel());
      jtp.addTab("Colors", new ColorsPanel());
      jtp.addTab("Flavors", new FlavorsPanel());
      add(jtp);
   }
}
class CitiesPanel extends JPanel {
   public CitiesPanel() {
      JButton b1 = new JButton("New York");
      add(b1);
      JButton b2 = new JButton("London");
      add(b2);
      JButton b3 = new JButton("Hong Kong");
      add(b3);
      JButton b4 = new JButton("Tokyo");
      add(b4);
   }
}
class ColorsPanel extends JPanel {
   public ColorsPanel() {
      JCheckBox cb1 = new JCheckBox("Red");
      add(cb1);
      JCheckBox cb2 = new JCheckBox("Green");
      add(cb2);
      JCheckBox cb3 = new JCheckBox("Blue");
      add(cb3);
       JCheckBox cb4 = new JCheckBox("Black");
      add(cb4);
   }
}
class FlavorsPanel extends JPanel {
   public FlavorsPanel() {
      JComboBox<String> jcb = new JComboBox<String>();
      jcb.addItem("Vanilla");
      jcb.addItem("Chocolate");
      jcb.addItem("Strawberry");
      jcb.addItem("cherries");
      add(jcb);
   }
}