/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardlayoutdemo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author duykhai
 */
public class CardLayoutDemo implements ItemListener {
    JPanel cards; // bảng điều khiển sử dụng CardLayout
    final static String BUTTONPANEL = "Button";
    final static String TEXTPANEL = "TextField";

    public void addComponentToPane(Container pane) {
        // Đặt JComboBox vào JPanel để có giao diện đẹp hơn.
        JPanel comboBoxPane = new JPanel(); // sử dụng FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        
        // Tạo "thẻ".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextFieldName", 20));

        // Tạo bảng có chứa "thẻ".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

   //Tạo GUI và hiển thị nó. Để đảm bảo an toàn cho luồng,
     // phương thức này phải được gọi từ chủ đề điều phối sự kiện.
    private static void createAndShowGUI() {
        // Đảm bảo rằng chúng ta có đồ trang trí cửa sổ đẹp.
        JFrame.setDefaultLookAndFeelDecorated(true);

        
        // Tạo và thiết lập cửa sổ.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo và thiết lập ngăn nội dung.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());

        // Hiển thị cửa sổ.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Lên lịch công việc cho chuỗi điều phối sự kiện:
       // tạo và hiển thị GUI của ứng dụng này.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}