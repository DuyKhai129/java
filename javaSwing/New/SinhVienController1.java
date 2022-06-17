/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Admin
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
