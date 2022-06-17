/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tabledemo;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duykhai
 */
public class TableDemo extends JPanel {

    private boolean DEBUG = false;

    public TableDemo() {
        super(new GridLayout(1, 0));
        MyTableModel model1=new MyTableModel();
        JTable table = new JTable(model1);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 140));
        table.setFillsViewportHeight(true);
        // Tạo ngăn cuộn và thêm bảng vào đó.
        JScrollPane scrollPane = new JScrollPane(table);
        // Thêm ngăn cuộn vào bảng này.
        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel {

        private String[] columnNames = {"Name",
            "Name",
            "Name",
            "quantily",
            "Vegetarian"};
        private Object[][] data = {{"Newt", "Dragon","Snail", new Integer(5), new Boolean(false)},
            {"dog", "cat", "duck", new Integer(10), new Boolean(true)},
            {"Tadpole", "Toad","Frog", new Integer(3), new Boolean(false)},
            {"Scorpion","Spider","Albatross", new Integer(9), new Boolean(true)},
            {"Canary", "Crow","Raven", new Integer(81), new Boolean(false)}
        };

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
        @Override
        public Object getValueAt(int row, int col){
            
            return data[row][col];
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //Không cần triển khai phương pháp này trừ khi bảng của bạn  có thể chỉnh sửa.
        @Override
        public boolean isCellEditable(int row, int col) {
           // Lưu ý rằng địa chỉ dữ liệu / ô là hằng số,cho dù ô đó xuất hiện ở đâu trên màn hình.
            
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
        //Không cần triển khai phương pháp này trừ khi bảng của bạn
        //dữ liệu có thể thay đổi.
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }
            data[row][col] = value;
            fireTableCellUpdated(row, col);
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
            for (int i = 0; i < numRows; i++) {
                System.out.print(" row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print(" " + data[i][j]);
                }
                System.out.println();
            }

            System.out.println("--------------------------");
        }
    }


    // Tạo GUI và hiển thị nó. Để đảm bảo an toàn cho luồng, phương pháp này phải
    // được gọi từ chuỗi điều phối sự kiện.
    private static void createAndShowGUI() {
        //Tạo và thiết lập cửa sổ.
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Tạo và thiết lập ngăn nội dung.
        TableDemo newContentPane = new TableDemo();
        newContentPane.setOpaque(true); //ngăn nội dung phải mờ
        frame.setContentPane(newContentPane);
        //Hiển thị cửa sổ.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Lên lịch công việc cho chuỗi điều phối sự kiện:
        //tạo và hiển thị GUI của ứng dụng này.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
