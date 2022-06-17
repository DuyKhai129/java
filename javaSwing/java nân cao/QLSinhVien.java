/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HTTTKT
 */
public class QLSinhVien extends JFrame {
    
    JLabel lbConnection;
    JTextField txtMSV;
    JTextField txtHoTen;
    JTextField txtNgaySinh;
    JTextField txtSDT;
    JComboBox gioiTinh;
    JTextField txtDiaChi;
    
    JButton btnThem, btnSua, btnXoa;
    
    JTable table;
    DefaultTableModel tModel;
    
    Connection con = null;
    String chuoikn = "jdbc:mysql://localhost:3306/qlsinhvien?autoReconnect=true&useSSL=false";
    String user = "root";
    String pass = "12345678";
    
    public QLSinhVien() {
        super("Quản lý sinh viên");
        table = new JTable();
        InitJComponents();
        if (CheckData()) {
            ShowData();
        }
        SetEvent();
    }
    
    public boolean CheckData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(chuoikn, user, pass);
            lbConnection.setText("<html><font color='green'>Kết nối với SQL thành công</font></html>");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e1) {
            e1.printStackTrace();
            lbConnection.setText("<html><font color='red'>Không thể kết nối với SQL</font></html>");
            return false;
        }
    }
    
    public void InitJComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JLabel lb = new JLabel("QUẢN LÝ SINH VIÊN");
        lb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lb);
        
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy++;
        add(new InputData(), gbc);
        
        gbc.gridy++;
        
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600, 300));
        sp.setViewportView(table);
        add(sp, gbc);
        
        gbc.gridy++;
        lbConnection = new JLabel("<html><font color='blue'>Đang kiểm tra kết nối...</font></html>");
        add(lbConnection, gbc);
    }
    
    public void ShowData() {
        Vector header = new Vector();
        header.add("MSV");
        header.add("Tên sinh viên");
        header.add("Ngày sinh");
        header.add("Số điện thoại");
        header.add("Giới tính");
        header.add("Địa chỉ");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(chuoikn, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        try {
            Statement stm = con.createStatement();
            String query = "select * from qlsinhvien";
            ResultSet rs = stm.executeQuery(query);
            Vector data = new Vector();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getInt(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                data.add(vector);
            }
            rs.close();
            stm.close();
            tModel = new DefaultTableModel(data, header) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            table.setModel(tModel);
            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void SetEvent() {
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!model.isSelectionEmpty()) {
                    int selectedRow = table.getSelectedRow();
                    txtMSV.setText(table.getValueAt(selectedRow, 0).toString());
                    txtHoTen.setText(table.getValueAt(selectedRow, 1).toString());
                    txtNgaySinh.setText(table.getValueAt(selectedRow, 2).toString());
                    txtSDT.setText(table.getValueAt(selectedRow, 3).toString());
                    gioiTinh.setSelectedItem(table.getValueAt(selectedRow, 4).toString());
                    txtDiaChi.setText(table.getValueAt(selectedRow, 5).toString());
                }
            }
        });
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String query = "INSERT INTO `qlsinhvien`.`qlsinhvien` (`hoten`, `ngaysinh`, `sdt`, `gioitinh`, `diachi`) VALUES (?, ?, ?, ?, ?);";
                try {
                    con = DriverManager.getConnection(chuoikn, user, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                ;
                PreparedStatement pr = null;
                if (con != null) {
                    try {
                        pr = con.prepareStatement(query);
                        //  pr.setInt(1, _id);
                        pr.setString(1, txtHoTen.getText());
                        pr.setString(2, txtNgaySinh.getText());
                        pr.setString(3, txtSDT.getText());
                        pr.setString(4, gioiTinh.getSelectedItem().toString());
                        pr.setString(5, txtDiaChi.getText());
                        pr.executeUpdate();
                        pr.close();
                    } catch (SQLException e) {
                        
                        e.printStackTrace();
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ShowData();
                    }
                }
            }
        });
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String query = "UPDATE `qlsinhvien`.`qlsinhvien` SET hoten = ?, ngaysinh = ?, `sdt` = ?, gioitinh = ?, diachi = ? WHERE (`msv` = ?)";
                try {
                    con = DriverManager.getConnection(chuoikn, user, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                ;
                PreparedStatement pr = null;
                if (con != null) {
                    try {
                        pr = con.prepareStatement(query);
                        //  pr.setInt(1, _id);
                        pr.setString(1, txtHoTen.getText());
                        pr.setString(2, txtNgaySinh.getText());
                        pr.setString(3, txtSDT.getText());
                        pr.setString(4, gioiTinh.getSelectedItem().toString());
                        pr.setString(5, txtDiaChi.getText());
                        pr.setString(6, txtMSV.getText());
                        pr.executeUpdate();
                        pr.close();
                    } catch (SQLException e) {
                        
                        e.printStackTrace();
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ShowData();
                    }
                }
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String query = "DELETE FROM `qlsinhvien`.`qlsinhvien` WHERE (`msv` = ?);";
                
                try {
                    con = DriverManager.getConnection(chuoikn, user, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement pr = null;
                try {
                    pr = con.prepareStatement(query);
                    pr.setString(1, txtMSV.getText());
                    pr.executeUpdate();
                    pr.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ShowData();
                }
            }
        });
    }
    
    class InputData extends JPanel {
        
        public InputData() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            //Mã sinh viên
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("Mã sinh viên: "), gbc);
            gbc.gridx++;
            txtMSV = new JTextField(10);
            add(txtMSV, gbc);

            //Tên sinh viên
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Tên sinh viên: "), gbc);
            gbc.gridx++;
            txtHoTen = new JTextField(10);
            add(txtHoTen, gbc);

            //Ngày sinh
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Ngày sinh: "), gbc);
            gbc.gridx++;
            txtNgaySinh = new JTextField(10);
            add(txtNgaySinh, gbc);

            //SĐT
            gbc.gridx = 2;
            gbc.gridy = 0;
            add(new JLabel("Số điện thoại: "), gbc);
            gbc.gridx++;
            txtSDT = new JTextField(10);
            add(txtSDT, gbc);

            //Giới tính
            gbc.gridx = 2;
            gbc.gridy++;
            add(new JLabel("Giới tính: "), gbc);
            gbc.gridx++;
            String[] gt = {"Nam", "Nữ"};
            gioiTinh = new JComboBox(gt);
            add(gioiTinh, gbc);

            //Địa chỉ
            gbc.gridx = 2;
            gbc.gridy++;
            add(new JLabel("Địa chỉ: "), gbc);
            gbc.gridx++;
            txtDiaChi = new JTextField();
            add(txtDiaChi, gbc);

            //Button
            JPanel btnPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.insets = new Insets(5, 5, 5, 5);
            gbc2.anchor = GridBagConstraints.WEST;
            
            gbc2.gridx = 0;
            gbc2.gridy++;
            
            btnThem = new JButton("Thêm");
            btnPanel.add(btnThem, gbc2);
            
            gbc2.gridx++;
            btnSua = new JButton("Sửa");
            btnPanel.add(btnSua, gbc2);
            
            gbc2.gridx++;
            btnXoa = new JButton("Xoá");
            btnPanel.add(btnXoa, gbc2);
            
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 4;
            add(btnPanel, gbc);
        }
    }
}
