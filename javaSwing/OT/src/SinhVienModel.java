/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class SinhVienModel {
     private int id;
     private String hoten;
     private String namsinh;
     private String sdt;
     private String gioitinh;
     private String diachi;

    public SinhVienModel(int id, String hoten, String namsinh, String sdt, String gioitinh, String diachi) {
        this.id = id;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
    }

    public SinhVienModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
      
}
