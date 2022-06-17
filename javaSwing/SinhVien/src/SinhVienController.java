/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author duykhai
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

    }
}
