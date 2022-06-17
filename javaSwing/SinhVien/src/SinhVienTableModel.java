
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SinhVienTableModel extends AbstractTableModel{

    private ArrayList<SinhVien> dsSinhVien=null;
    private Object[][] data=null;
    public SinhVienTableModel(ArrayList<SinhVien> _dsSinhVien) {
        System.out.println("innit sinhvienmodel");
        dsSinhVien=_dsSinhVien;
        data=new Object[dsSinhVien.size()][];
      
       for(int i=0;i<dsSinhVien.size();i++){
           SinhVien sv=dsSinhVien.get(i);
          Object[] row={sv.getId(),sv.getHoTen(),sv.getDiaChi(),sv.getTenLop(),sv.getNamSinh()};
          data[i]=row;           
        }
    }
    @Override
    public int getRowCount() {
        return dsSinhVien.size();
    }

    @Override
    public int getColumnCount() {
         return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      System.out.println("rowIndex: "+rowIndex+"  columnIndex"+columnIndex);
       return data[rowIndex][columnIndex];   
    }
    
}
