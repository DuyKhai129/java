

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public interface SinhVienDAO {
    public ArrayList<SinhVien> getAllSinhVien();

    public void insert(SinhVien sv);

    public void updateSinhVien(SinhVien sv);

    public boolean DeleteSinhVien(SinhVien sv);

    public SinhVien findSinhVienByID(int id);

    public SinhVien findByName(String name);
}
