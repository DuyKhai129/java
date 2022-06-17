/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletabletest;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duykhai
 */
public class MyTableModel extends AbstractTableModel {
    
    private final static String[] columnNames = {"STT", "Họ và Tên", "Địa Chỉ", "Năn Sinh"};
    private Object[][] values = {
        {
            1," Nguyễn Văn A","Thái Nguyên",1980
        }, 
        {
            2," Nguyễn Văn B","Thái Nguyên",1989
        }, 
        {
             3," Nguyễn Thị H","Thái Bình",1988
        }, 
        {
            4," Trần Bá Quát","Nam Đinh ",1991
        }, 
        {
            5," Trần Văn Za","Bình Đinh ",1992
        },
        {
            6," Trần Văn Zaa","Bình Đinh ",1999
        },
        {
            7," Trần Văn Ta","Bình Đinh ",1979
        }
    };

    @Override
    public int getRowCount() {
        return values.length;
    }

    @Override
    public int getColumnCount() {
        return values[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println("Run Modul");
        return values[rowIndex][columnIndex];
    }
    @Override
    public String getColumnName(int column){
        
        return columnNames[column];
    }
}
