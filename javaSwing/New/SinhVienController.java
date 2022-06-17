/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SinhVienController {
    
    private SinhVienTableModel sinhvienModel;
    private SinhVienView sinhvienView;

    public SinhVienController(SinhVienView _sinhvienView, SinhVienTableModel _sinhvienModel) {
        this.sinhvienView = _sinhvienView;
        sinhvienModel = _sinhvienModel;
    }

    public void showSinhVienView() {
        sinhvienView.showListSinhVien(sinhvienModel);
        sinhvienView.setVisible(true);        
        //sinhvienView.setEnabled(true);
    }
    
}
