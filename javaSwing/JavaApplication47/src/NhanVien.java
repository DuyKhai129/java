/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class NhanVien {
    private int id;
    private String hoTen, namsinh, sodienthoai, chucvu;

    public NhanVien() {
    }

    public NhanVien(int id, String hoTen, String namsinh, String sodienthoai, String chucvu) {
        this.id = id;
        this.hoTen = hoTen;
        this.namsinh = namsinh;
        this.sodienthoai = sodienthoai;
        this.chucvu = chucvu;
    }

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

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", hoTen=" + hoTen + ", namsinh=" + namsinh + ", sodienthoai=" + sodienthoai + ", chucvu=" + chucvu + '}';
    }
    
}
