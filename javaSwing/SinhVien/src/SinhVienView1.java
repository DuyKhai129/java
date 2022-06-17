/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.table.TableModel;
/**
 *
 * @author duykhai
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
 
        btnSua = new JButton("Sửa");
     
        btnXoa = new JButton("Xóa");

        btnHuy = new JButton("Hủy");

        btnGhi = new JButton("Ghi");

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
        southPane = new Panel(new BorderLayout());
        southPane.add(buttonPane, BorderLayout.NORTH);
        southPane.add(textPane, BorderLayout.CENTER);
        this.getContentPane().add(southPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
    }
    public void showListSinhVien(SinhVienTableModel sinhvienModel) {
        table = new JTable(sinhvienModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        tblPane = new JScrollPane(table);      
     
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
    }
    
public void fillSinhVienFromSelectedRow() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtID.setText(table.getModel().getValueAt(row, 0).toString());
            txtHoten.setText(table.getModel().getValueAt(row, 1).toString());
            txtDiachi.setText(table.getModel().getValueAt(row, 2).toString());
            txtLop.setText(table.getModel().getValueAt(row, 3).toString());
            txtNamsinh.setText(table.getModel().getValueAt(row, 4).toString());
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
