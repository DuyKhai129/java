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
public interface SinhVienDAO {

    public ArrayList<SinhVien> getAllSinhVien();

    public void insert(SinhVien sv);

    public void updateSinhVien(SinhVien sv);

    public boolean DeleteSinhVien(SinhVien sv);

    public SinhVien findSinhVienByID(int id);

    public SinhVien findByName(String name);
}
