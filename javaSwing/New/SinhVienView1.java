/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class SinhVienView1 extends JFrame {

    JButton btnThem, btnSua, btnXoa, btnHuy, btnGhi;
    JTextField txtID, txtHoten, txtDiachi, txtLop, txtNamsinh;
    JScrollPane tblPane;
    Panel southPane, textPane, buttonPane;
    JTable table;

   

    public SinhVienView1() {

        buttonPane = new Panel(new FlowLayout());
        btnThem = new JButton("Thêm");
        //btnThem.addActionListener(this);
        btnSua = new JButton("Sửa");
        //btnSua.addActionListener(this);
        btnXoa = new JButton("Xóa");
        // btnXoa.addActionListener(this);
        btnHuy = new JButton("Hủy");
        // btnHuy.addActionListener(this);
        btnGhi = new JButton("Ghi");
        // btnGhi.addActionListener(this);
        buttonPane.add(btnThem);
        buttonPane.add(btnSua);
        buttonPane.add(btnXoa);
        buttonPane.add(btnHuy);
        buttonPane.add(btnGhi);
        textPane = new Panel(new GridLayout(5, 2));
        txtID = new JTextField(5);
        txtHoten = new JTextField(15);
        txtDiachi = new JTextField(15);
        txtLop = new JTextField(10);
        txtNamsinh = new JTextField(15);
        textPane.add(new JLabel("ID:"));
        textPane.add(txtID);
        textPane.add(new JLabel("Họ Tên:"));
        textPane.add(txtHoten);
        textPane.add(new JLabel("Dia Chi:"));
        textPane.add(txtDiachi);
        textPane.add(new JLabel("Lớp:"));
        textPane.add(txtLop);
        textPane.add(new JLabel("Nam Sinh"));
        textPane.add(txtNamsinh);
        //ButtonJTextFieldControl(0);
        southPane = new Panel(new BorderLayout());
        southPane.add(buttonPane, BorderLayout.NORTH);
        southPane.add(textPane, BorderLayout.CENTER);
        //this.getContentPane().add(tblPane, BorderLayout.CENTER);
        this.getContentPane().add(southPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
    }
    public void showListSinhVien(SinhVienTableModel sinhvienModel) {
        table = new JTable(sinhvienModel);
           // thiet lap do rong cot cho Table
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        tblPane = new JScrollPane(table);      
     
        //this.setLayout(new BorderLayout());
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
    }
    
public void fillSinhVienFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtID.setText(table.getModel().getValueAt(row, 0).toString());
            txtHoten.setText(table.getModel().getValueAt(row, 1).toString());
            txtDiachi.setText(table.getModel().getValueAt(row, 2).toString());
            txtLop.setText(table.getModel().getValueAt(row, 3).toString());
            txtNamsinh.setText(table.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            btnThem.setEnabled(false);
            btnXoa.setEnabled(true);            
            btnSua.setEnabled(true);  
            btnGhi.setEnabled(false);
            btnHuy.setEnabled(false);
        }
}
    public void addAddSinhVientListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    public void addEdiSinhVienListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    public void addDeleteSinhVientListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
    }


    public void addListSinhVienSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }

}
