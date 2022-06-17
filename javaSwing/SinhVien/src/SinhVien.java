/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class SinhVien {
     private int id;
    private String hoTen,diaChi,tenLop,namSinh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public SinhVien() {
    }

    public SinhVien(String hoTen, String diaChi, String tenLop, String namSinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }

    public SinhVien(int id, String hoTen, String diaChi, String tenLop, String namSinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }
     //@Override
   // public String toString() {
      //  return "{" + "id=" + id + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", tenLop=" + tenLop + ", namSinh=" + namSinh + '}';
   // }
}
