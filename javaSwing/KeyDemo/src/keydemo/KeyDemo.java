/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package keydemo;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class KeyDemo extends JFrame implements KeyListener{
    private String x1 = "",x2 ="",x3 = "";
    private TextArea txtArea;
    public KeyDemo(){
        txtArea = new TextArea(10,15);
        txtArea.setText("Nhấn phím bất kỳ trên bàn phím:");
        txtArea.setEnabled(false);
        this.add(txtArea);
        this.addKeyListener(this);
        this.setBounds(450,450,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void setLines2and3(KeyEvent e){
        x2 = "this key is: " + (e.isActionKey() ? "" : "not") + "an Action key";
        String temp = e.getKeyModifiersText(e.getModifiers());
        x3 = "Modifies key press: " + (temp.equals("") ? "Non" : temp);
        System.out.println("3");
        txtArea.setText(x1 + "\n" + x2 + "\n" + x3 + "\n");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KeyDemo f = new KeyDemo();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       x1 = "key Typed :" + e.getKeyText(e.getKeyCode());
        setLines2and3(e);
        System.out.println("2");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        x1 = "key Pressed :" + e.getKeyText(e.getKeyCode());
        setLines2and3(e);
        System.out.println("4");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        x1 = "key Relased :" + e.getKeyText(e.getKeyCode());
        setLines2and3(e);
        System.out.println("1");
    }
    
}
