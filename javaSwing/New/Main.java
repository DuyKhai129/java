/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        SinhVienimplDAO sinhVienDAO = new SinhVienimplDAO("jdbc:mysql://localhost:3306/mydatabase", "root", "admin");
        SinhVienTableModel sinhvienModel = new SinhVienTableModel(sinhVienDAO.getAllSinhVien());
        SinhVienView2 sinhvienView = new SinhVienView2();
        SinhVienController2 controller = new SinhVienController2(sinhvienView, sinhvienModel);
        controller.showSinhVienView();
    }
}
