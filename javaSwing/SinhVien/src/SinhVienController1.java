/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author duykhai
 */
public class SinhVienController1 {
    private SinhVienTableModel sinhvienModel;
    private SinhVienView1 sinhvienView;

    public SinhVienController1(SinhVienView1 _sinhvienView, SinhVienTableModel _sinhvienModel) {
        this.sinhvienView = _sinhvienView;
        sinhvienModel = _sinhvienModel;
    }

    public void showSinhVienView() {
        sinhvienView.showListSinhVien(sinhvienModel);
        sinhvienView.addListSinhVienSelectionListener(new ListSinhVienSelectionListener());
        sinhvienView.setVisible(true);        
        sinhvienView.setEnabled(true);
    }
    class ListSinhVienSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            sinhvienView.fillSinhVienFromSelectedRow();
        }
    }
}
