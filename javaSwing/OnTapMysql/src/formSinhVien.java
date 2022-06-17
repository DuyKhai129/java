
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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class formSinhVien extends JFrame{

    JTable table;
    JTextField txtId,txtHT,txtNS,txtSDT,txtDC;
    JComboBox cbGT;
    JButton btThem,btSua,btXoa,btTK;
    SinhVienDAO svd = new SinhVienDAO();
    public formSinhVien(String title) throws HeadlessException {
        super(title);
        initComponents();
        showData(svd.getAll());
        event();
    }
    public void initComponents(){
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //pnTitle 
        JPanel pnTitle = new JPanel();
        JLabel lbTitle = new JLabel("Thông tin sinh viên");
        lbTitle.setFont(new Font("Tomaho",Font.BOLD,20));
        lbTitle.setForeground(Color.red);
        pnTitle.add(lbTitle);
            this.getContentPane().add(pnTitle,BorderLayout.NORTH);
        //pnInput
        JPanel pnInput = new JPanel(new BorderLayout());
        //pnText 
        JPanel pnText = new JPanel(new GridLayout(3, 2));
        txtId = new JTextField(5);
        txtId.enable(false);
        txtHT = new JTextField(10);
        txtNS =  new JTextField(10);
        txtSDT =  new JTextField(10);
        String[] gt ={"Lựa chọn","Nam","Nữ"};
        cbGT = new JComboBox(gt);
        txtDC =  new JTextField(10);
        
        pnText.add(new JLabel("ID:"));
        pnText.add(txtId);
         pnText.add(new JLabel("Họ tên:"));
        pnText.add(txtHT);
         pnText.add(new JLabel("Năm sinh:"));
        pnText.add(txtNS);
         pnText.add(new JLabel("SĐT:"));
        pnText.add(txtSDT);
         pnText.add(new JLabel("Giới tính:"));
        pnText.add(cbGT);
         pnText.add(new JLabel("Địa chỉ:"));
        pnText.add(txtDC);
            pnInput.add(pnText,BorderLayout.NORTH);
        //pnButton 
        JPanel pnButton = new JPanel(new FlowLayout());
        btThem = new JButton("Thêm");
        pnButton.add(btThem);
        btSua = new JButton("Sửa");
        pnButton.add(btSua);
        btXoa = new JButton("Xóa");
        pnButton.add(btXoa);
        btTK = new JButton("Tìm Kiếm");
        pnButton.add(btTK);
            pnInput.add(pnButton,BorderLayout.SOUTH);
        this.getContentPane().add(pnInput,BorderLayout.CENTER);
        //pnTable 
        table = new JTable();
        JScrollPane pnTable = new JScrollPane(table);
        pnTable.setPreferredSize(new Dimension(300, 350));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID","Họ tên","năm sinh","SĐT","Giới tính","Địa chỉ"}));
        this.getContentPane().add(pnTable,BorderLayout.SOUTH);
    }
    public void showData(List<SinhVienDTO>listSV){
        List<SinhVienDTO> ListSV = new ArrayList<>();
        ListSV = listSV;
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ListSV.forEach(sv->{
            tableModel.addRow(
                new Object[]{sv.getId(),sv.getHoten(),sv.getNamsinh(),sv.getSdt(),sv.getGioitinh(), sv.getDiachi()
                    });
        });
    }
    public void event(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int SelectRow = table.getSelectedRow();
                txtId.setText(table.getValueAt(SelectRow, 0).toString());
                txtHT.setText(table.getValueAt(SelectRow, 1).toString());
                txtNS.setText(table.getValueAt(SelectRow, 2).toString());
                txtSDT.setText(table.getValueAt(SelectRow, 3).toString());
                int i=0;
                        while(true){
                            String gioitinh = cbGT.getItemAt(i).toString();
                            if(gioitinh.equalsIgnoreCase(table.getValueAt(SelectRow, 4).toString())){
                               cbGT.setSelectedIndex(i);
                               break;
                            }
                            i++;
                        }
                        
                txtDC.setText(table.getValueAt(SelectRow, 5).toString());
            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVienDTO sv = new SinhVienDTO();
                sv.setHoten(txtHT.getText());
                sv.setNamsinh(txtNS.getText());
                sv.setSdt(txtSDT.getText());
                sv.setGioitinh(cbGT.getSelectedItem().toString());
                sv.setDiachi(txtDC.getText());
                svd.Insert(sv);
                showData(svd.getAll());
            }
        });
        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinhVienDTO sv = new SinhVienDTO();
                sv.setHoten(txtHT.getText());
                sv.setNamsinh(txtNS.getText());
                sv.setSdt(txtSDT.getText());
                sv.setGioitinh(cbGT.getSelectedItem().toString());
                sv.setDiachi(txtDC.getText());
                sv.setId(Integer.parseInt(txtId.getText()));
                svd.update(sv);
                showData(svd.getAll());
            }
        });
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    SinhVienDTO sv = new SinhVienDTO();
                sv.setId(Integer.parseInt(txtId.getText()));
                svd.delete(sv);
                showData(svd.getAll());
            }
        });
        btTK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SinhVienDTO sv = new SinhVienDTO();
                sv.setHoten(txtHT.getText());
                showData(svd.Search(sv));
            }
        });
    }
    public static void main(String[] args) {
        new formSinhVien("Quản lý sinh viên").setVisible(true);
    }
}
