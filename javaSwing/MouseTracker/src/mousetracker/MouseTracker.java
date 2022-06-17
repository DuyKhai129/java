/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mousetracker;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class MouseTracker extends JFrame implements MouseListener, MouseMotionListener{
    private Label statusBar;
    public MouseTracker(){
        super("Demo MouseTracker");
        statusBar = new Label();
        statusBar.setFont(new Font("Time New Roman", Font.BOLD, 16));
        this.add(statusBar,BorderLayout.SOUTH);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(400,400,500,700);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         MouseTracker application = new MouseTracker();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       statusBar.setText(" Mouse Click at [" + e.getX() + "," + e.getY() + "]");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statusBar.setText(" Mouse Released at [" + e.getX() + "," + e.getY() + "]");
        System.out.println("Mose Released ");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        statusBar.setText(" Mouse Pressed at [" + e.getX() + "," + e.getY() + "]");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        statusBar.setText("Mouse in Entered");
        System.out.println("Mose Entered ");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        statusBar.setText("Mouse outside window");
        System.out.println("Mose Exit ");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        statusBar.setText("Dragged at [" + e.getX()
                + ", " + e.getY() + "]");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        statusBar.setText("Moved at [" + e.getX()
                + ", " + e.getY() + "]");
    }

    
}
