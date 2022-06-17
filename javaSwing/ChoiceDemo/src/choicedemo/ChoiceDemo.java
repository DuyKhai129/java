/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package choicedemo;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author duykhai
 */
public class ChoiceDemo extends Frame implements ItemListener{
private Choice myChoice;
    public ChoiceDemo() {
        super("Choice demo!");
        myChoice = new Choice(); // Khởi tạo
        myChoice.addItem("Red"); // Thêm item red
        myChoice.addItem("Yellow"); // Thêm item blue
        myChoice.addItem("Green"); // Thêm item green
        myChoice.addItem("Balck"); // Thêm item Balck
        myChoice.addItem("Pink"); // Thêm item Pink
        myChoice.addItemListener(this); // đăng ký đối tượng lắng nghe sự kiện cho choice Bắt sự kiện
        this.add(myChoice); // Gắn vào frame
        this.setBackground(Color.YELLOW);
        myChoice.select(1);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //Phương thức bắt sự kiện click vào nút đóng frame
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        ChoiceDemo myFrame = new ChoiceDemo();
        myFrame.setSize(300, 150); // Định kích cỡ frame
        myFrame.setVisible(true); // Hiển thị frame
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String item = null;
        System.out.println("chon index la "+myChoice.getSelectedIndex()+"tuong ung voi Item la"+ myChoice.getSelectedItem());
        if (e.getStateChange() == ItemEvent.SELECTED) {
            item = (String) e.getItem();
        }
        if (item.equals("Red")) // Đổi màu red
        {
            this.setBackground(Color.red);
        }
        if (item.equals("Blue")) // Đổi màu blue
        {
            this.setBackground(Color.yellow);
        }
        if (item.equals("Green")) // Đổi màu green
        {
            this.setBackground(Color.green);
        }
         if (item.equals("Balck")) // Đổi màu green
        {
            this.setBackground(Color.black);
        }
          if (item.equals("Pink")) // Đổi màu green
        {
            this.setBackground(Color.pink);
        }
        this.repaint(); // Vẽ lại màu nền}
    }
    
}
