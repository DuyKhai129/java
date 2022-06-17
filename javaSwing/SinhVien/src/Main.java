/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class Main {
    public static void main(String[] args) {
        SinhVienimplDAO sinhVienDAO = new SinhVienimplDAO("jdbc:mysql://localhost:3306/sinhvien", "root", "");
        SinhVienTableModel sinhvienModel = new SinhVienTableModel(sinhVienDAO.getAllSinhVien());
        SinhVienView2 sinhvienView = new SinhVienView2();
        SinhVienController2 controller = new SinhVienController2(sinhvienView, sinhvienModel);
     // SinhVienView1 sinhvienView = new SinhVienView1();
     // SinhVienController1 controller = new SinhVienController1(sinhvienView, sinhvienModel);
        controller.showSinhVienView();
    }
}
