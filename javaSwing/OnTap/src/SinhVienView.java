
import com.sun.source.tree.Tree;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author duykhai
 */
public class SinhVienView extends JFrame {

    JLabel lbConnection;
    JTable table;
    JButton btInsert, btUpdate, btDelete, btClear;
    JTextField txtId, txtName, txtDateOfBirth, txtPhone, txtAddress;
    JComboBox cbGender;

    public SinhVienView(String title) throws HeadlessException {
        super(title);
        initComponents();
        showData(SinhVienDAO.getAll());
        Event();

    }

    public void initComponents() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sử lý JFrame:Sau khi JFrame bị đóng, chương trình cũng sẽ tắt theo.
        this.setLocationRelativeTo(null);//Canh JFrame ở giữa màn hình
        // this.setAlwaysOnTop(true);// giúp dừng JFrame khi ta click chuột vào trong code thì nó vẫn đứng im
        //Title
        JPanel pnTitle = new JPanel();
        JLabel lbTitle = new JLabel("Thông tin sinh viên");
        lbTitle.setFont(new Font("Tomaho", Font.BOLD, 20));
        lbTitle.setForeground(Color.red);
        pnTitle.add(lbTitle);

        JPanel pnSouth = new JPanel(new BorderLayout());
        // bắt đầu North trong pnBorder
        JPanel pnText = new JPanel(new GridLayout(3, 2));
        txtId = new JTextField(15);
        txtId.enable(false);
        txtName = new JTextField(15);
        txtDateOfBirth = new JTextField(15);
        txtPhone = new JTextField(15);
        txtAddress = new JTextField(15);
        String[] gender = {"--Lựa Chọn--", "Nam", "Nữ"};
        cbGender = new JComboBox(gender);
        
        pnText.add(new JLabel("ID: "));
        pnText.add(txtId);
        pnText.add(new JLabel("Họ và tên: "));
        pnText.add(txtName);
        pnText.add(new JLabel("Ngày sinh: "));
        pnText.add(txtDateOfBirth);
        pnText.add(new JLabel("SĐT: "));
        pnText.add(txtPhone);
        pnText.add(new JLabel("Giới tính: "));
        pnText.add(cbGender);
        pnText.add(new JLabel("Địa  chỉ: "));
        pnText.add(txtAddress);
        pnSouth.add(pnText, BorderLayout.NORTH);
        //bắt đầu Center trong pnBorder
        JPanel pnButton = new JPanel(new FlowLayout());
        btInsert = new JButton("Insert");
        pnButton.add(btInsert);
        btUpdate = new JButton("Update");
        pnButton.add(btUpdate);
        btDelete = new JButton("Delete");
        pnButton.add(btDelete);
        btClear = new JButton("Clear");
        pnButton.add(btClear);
        pnSouth.add(pnButton, BorderLayout.CENTER);

        //table
        table = new JTable();
        JScrollPane scpnTable = new JScrollPane(table);
        scpnTable.setPreferredSize(new Dimension(300, 310));//đặt kích thước cho bảng theo ý muốn
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Họ têm", "Năm sinh", "SĐT", "Giới tính", "Địa chỉ"
                }
        ));
        // this.add(pnBorder);//đưa pnBorder vào JFrame
        this.getContentPane().add(pnTitle, BorderLayout.NORTH);
        this.getContentPane().add(pnSouth, BorderLayout.CENTER);
        this.getContentPane().add(scpnTable, BorderLayout.SOUTH);
    }

    public void showData(List<SinhVien> listSV) {
        List<SinhVien> svList = new ArrayList<>();
        svList = listSV;
        DefaultTableModel tableModel;
       // table.getModel();
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);//xóa bỏ thông tin trc trong bảng
        // sử dụng vòng lặp forEach để duyệt các phần tử.
        svList.forEach(sv -> {
            tableModel.addRow(new Object[]{
                sv.getId(), sv.getName(), sv.getDate_of_birth(), sv.getPhone(), sv.getGender(), sv.getAddress()
            });
        });

    }

    public void showDetail() {
        int i = table.getSelectedRow();
        txtId.setText(table.getValueAt(i, 0).toString());

    }

    public void Event() {

        /*table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int row = table.getSelectedRow();
                txtId.setText(table.getValueAt(row, 0).toString());
                txtName.setText(table.getValueAt(row, 1).toString());
                txtDateOfBirth.setText(table.getValueAt(row, 2).toString());
                txtPhone.setText(table.getValueAt(row, 3).toString());
                //sử lý combobox
                int i =0;
                while(true){
                    String gender = cbGender.getItemAt(i).toString();
                    //kiểm tra xem cái combobox nào có cái tên = giá trị mà ta click chuột vào
                    if(gender.equalsIgnoreCase(table.getValueAt(row, 4).toString())){
                        cbGender.setSelectedIndex(i);
                        break;
                    }
                    i++;
                }
                txtAddress.setText(table.getValueAt(row, 5).toString());
                }
       });*/
        ListSelectionModel lsm = table.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!lsm.isSelectionEmpty()) {
                    int row = table.getSelectedRow();
                    txtId.setText(table.getValueAt(row, 0).toString());
                    txtName.setText(table.getValueAt(row, 1).toString());
                    txtDateOfBirth.setText(table.getValueAt(row, 2).toString());
                    txtPhone.setText(table.getValueAt(row, 3).toString());
                    //sử lý combobox
                    int i = 0;
                    while (true) {
                        String gender = cbGender.getItemAt(i).toString();
                        //kiểm tra xem cái combobox nào có cái tên = giá trị mà ta click chuột vào
                        if (gender.equalsIgnoreCase(table.getValueAt(row, 4).toString())) {
                            cbGender.setSelectedIndex(i);
                            break;
                        }
                        i++;
                    }
                    txtAddress.setText(table.getValueAt(row, 5).toString());
                }
            }
        });
        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtDateOfBirth.setText("");
                txtPhone.setText("");
                cbGender.setSelectedItem("--Lựa Chọn--");
            }
        });
        btInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVien sv = new SinhVien();
                sv.setName(txtName.getText());
                sv.setDate_of_birth(txtDateOfBirth.getText());
                sv.setPhone(txtPhone.getText());
                sv.setGender(cbGender.getSelectedItem().toString());
                sv.setAddress(txtAddress.getText());
                SinhVienDAO.insert(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công!");
                //load dữ liệu lên table

                showData(SinhVienDAO.getAll());
            }
        });
        btUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVien sv = new SinhVien();
                sv.setName(txtName.getText());
                sv.setDate_of_birth(txtDateOfBirth.getText());
                sv.setPhone(txtPhone.getText());
                sv.setGender(cbGender.getSelectedItem().toString());
                sv.setAddress(txtAddress.getText());
                sv.setId(Integer.parseInt(txtId.getText()));
                SinhVienDAO.update(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công!");
                //load dữ liệu lên table
                showData(SinhVienDAO.getAll());
            }
        });
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVien sv = new SinhVien();
                sv.setId(Integer.parseInt(txtId.getText()));
                SinhVienDAO.delete(sv);
                JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công!");
                //load dữ liệu lên table
                showData(SinhVienDAO.getAll());
            }
        });
    }

    public static void main(String[] args) {
        new SinhVienView("QUẢN LÝ SINH VIÊN").setVisible(true);
    }

}
