
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class SinhVienView extends JFrame{

    
    JTable table;
    JTextField txtid,txthoten,txtnamsinh,txtsdt,txtdiachi;
    JComboBox cbgioitinh;
    JButton btThem,btSua,btXoa,btClear;
    public SinhVienView(String title) throws HeadlessException {
        super(title);
        initcomponents();
        showData(SinhVienController.getAll());
        event();
    }
    
    public void initcomponents(){
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //panelTitle
        JPanel pnTitle = new JPanel();
        JLabel lbTitle = new JLabel("Thông tin sinh viên");
        lbTitle.setFont(new Font("tohoma",Font.BOLD,20));
        lbTitle.setForeground(Color.red);
        pnTitle.add(lbTitle);
        this.getContentPane().add(pnTitle,BorderLayout.NORTH);
        
        //pninput
        JPanel pnInput = new JPanel( new BorderLayout());
        //pntext
        JPanel pnText = new JPanel(new GridLayout(3, 2));
        txtid = new JTextField(10);
        txtid.enable(false);
        txthoten = new JTextField(10);
        txtnamsinh = new JTextField(10);
        txtsdt = new JTextField(10);
        String[] gt ={"Khác","Nam","Nữ"};
        cbgioitinh = new JComboBox(gt);
        txtdiachi = new JTextField(10);
        
        pnText.add(new JLabel("Id: "));
        pnText.add(txtid);
        pnText.add(new JLabel("Họ tên: "));
        pnText.add(txthoten);
        pnText.add(new JLabel("nam sinh: "));
        pnText.add(txtnamsinh);
        pnText.add(new JLabel("SĐT: "));
        pnText.add(txtsdt);
        pnText.add(new JLabel("giới tinh: "));
        pnText.add(cbgioitinh);
        pnText.add(new JLabel("địa chỉ: "));
        pnText.add(txtdiachi);
            pnInput.add(pnText,BorderLayout.NORTH);
        
        //pnButton
        JPanel pnButton = new JPanel(new FlowLayout());
        btThem = new JButton("thêm");
        pnButton.add(btThem);
        btSua = new JButton("Sửa");
        pnButton.add(btSua);
        btXoa = new JButton("Xóa");
        pnButton.add(btXoa);
        btClear = new JButton("Clear");
        pnButton.add(btClear);
            pnInput.add(pnButton,BorderLayout.CENTER);
        this.getContentPane().add(pnInput,BorderLayout.CENTER);
        
        //pnTable
        table = new JTable();
        JScrollPane pnTable = new JScrollPane(table);
       pnTable.setPreferredSize(new Dimension(300, 310));
        table.setModel(new DefaultTableModel(
               new Object[][]{}, 
               new String[]{"Id","Họ tên","namsinh","SĐT","giới tính","địa chỉ"}));
        this.getContentPane().add(pnTable,BorderLayout.SOUTH);
       
    }
    
    public void showData(List<SinhVienModel>listsv){
        List<SinhVienModel> ListSV = new ArrayList<>();
        ListSV = listsv;
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
       
        ListSV.forEach(sv->{
            tableModel.addRow(new Object[]{
                sv.getId(),sv.getHoten(),sv.getNamsinh(),sv.getSdt(),sv.getGioitinh(),sv.getDiachi()
            });
        });
    }
    public void event(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectRow = table.getSelectedRow();
                txtid.setText(table.getValueAt(selectRow, 0).toString());
                txthoten.setText(table.getValueAt(selectRow, 1).toString());
                txtnamsinh.setText(table.getValueAt(selectRow, 2).toString());
                txtsdt.setText(table.getValueAt(selectRow, 3).toString());
                int i=0;
                while(true){
                     String gioitinh = cbgioitinh.getItemAt(i).toString();
                     if(gioitinh.equalsIgnoreCase(table.getValueAt(selectRow, 4).toString())){
                         cbgioitinh.setSelectedIndex(i);
                         break;
                     }
                     i++;
                }
                txtdiachi.setText(table.getValueAt(selectRow, 5).toString());
            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVienModel sv = new SinhVienModel();
                sv.setHoten(txthoten.getText());
                sv.setNamsinh(txtnamsinh.getText());
                sv.setSdt(txtsdt.getText());
                sv.setGioitinh(cbgioitinh.getSelectedItem().toString());
                sv.setDiachi(txtdiachi.getText());
                SinhVienController.insert(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công");
                showData(SinhVienController.getAll());
            }
        });
        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 SinhVienModel sv = new SinhVienModel();
                sv.setHoten(txthoten.getText());
                sv.setNamsinh(txtnamsinh.getText());
                sv.setSdt(txtsdt.getText());
                sv.setGioitinh(cbgioitinh.getSelectedItem().toString());
                sv.setDiachi(txtdiachi.getText());
                sv.setId(Integer.parseInt(txtid.getText()));
                SinhVienController.update(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công");
                showData(SinhVienController.getAll());
            }
        });
        btClear.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtid.setText("");
                txthoten.setText("");
                txtnamsinh.setText("");
                txtsdt.setText("");
                cbgioitinh.setSelectedItem("Khác");
                txtdiachi.setText("");
            }
        });
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  SinhVienModel sv = new SinhVienModel();
                sv.setId(Integer.parseInt(txtid.getText()));
                SinhVienController.delete(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công");
                showData(SinhVienController.getAll());
            }
        });
    }
    public static void main(String[] args) {
        new SinhVienView("Quản lý Sinh viên").setVisible(true);
    }
}
