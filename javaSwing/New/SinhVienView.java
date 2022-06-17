/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;
import SQL.ConnectionDatabase;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SinhVienView extends JFrame {
    
    JTable table;
    public void showListSinhVien(SinhVienTableModel sinhvienModel) {
        table = new JTable(sinhvienModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
       JScrollPane tblPane = new JScrollPane(table);
        // thiet lap do rong cot cho Table
        this.setLayout(new BorderLayout());
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
    }
    public SinhVienView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);      
    }
}
