
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private String name;
    private String date_of_birth;
    private String phone,gender,address;
   

    public SinhVien() {
    }

    public SinhVien(int id, String name, String date_of_birth, String phone, String gender, String address) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public String getDate_of_birth() {
       // SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //return df.format(date_of_birth);
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", name=" + name + ", date_of_birth=" + date_of_birth + ", phone=" + phone + ", gender=" + gender + ", address=" + address + '}';
    }

   

}
