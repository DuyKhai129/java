/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flowlayout_boxlayout_borderlay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author duykhai
 */
public class FlowLayout_BoxLayout_BorderLay extends JFrame {
    public FlowLayout_BoxLayout_BorderLay(String title ) throws HeadlessException{
        super(title);
        initUI();
    }
    public void initUI(){
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        
        JPanel pnBoderLayout = new JPanel(new BorderLayout());
        //bắt đầu vùng North
        JPanel PnNorth = new JPanel();
        JLabel lbtirle = new JLabel("Cộng trừ nhân chia");
        lbtirle.setForeground(Color.BLACK);
        lbtirle.setFont(new Font("Tahoma",Font.BOLD,39));
        PnNorth.add(lbtirle);
        pnBoderLayout.add(PnNorth,BorderLayout.NORTH);
        //kết thúc vùng North
        
        //bắt đầu vùng West
        JPanel PnWest = new JPanel();
        PnWest.setLayout(new BoxLayout(PnWest,BoxLayout.Y_AXIS));
        PnWest.setBackground(Color.GREEN);
        JButton btnGia = new JButton("Giải");
        JButton btnXoa = new JButton("Xóa");
        JButton btnThoat = new JButton("Thoát");
        Border borderWest = BorderFactory.createLineBorder(Color.yellow);
        TitledBorder titledBorderWest = new TitledBorder(borderWest,"Chọn tác vụ");
        PnWest.setBorder(titledBorderWest);
        PnWest.add(btnGia);
        PnWest.add(btnXoa);
        PnWest.add(btnThoat);
        pnBoderLayout.add(PnWest,BorderLayout.WEST);
        //kết thúc vùng West
        
        //bắt đầu vùng South
        JPanel PnSouth = new JPanel();
        PnSouth.setPreferredSize(new Dimension(0,30));
        PnSouth.setBackground(Color.PINK);
        pnBoderLayout.add(PnSouth,BorderLayout.SOUTH);
        //kết thúc vùng South
        this.add(pnBoderLayout);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FlowLayout_BoxLayout_BorderLay("Caculator").setVisible(true);
    }
    
}
