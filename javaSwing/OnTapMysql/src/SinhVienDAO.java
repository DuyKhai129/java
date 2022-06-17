/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
/**
 *
 * @author duykhai
 */
public class SinhVienDAO {
    Connection con;
    private Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ontap","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public List<SinhVienDTO>getAll(){
        List<SinhVienDTO> listSV = new ArrayList<>();
        con = getConnection();
        Statement sm = null;
        ResultSet rs  = null;
        try {
            sm = con.createStatement();
            rs = sm.executeQuery("select * from sinhvien");
            while(rs.next()){
                SinhVienDTO sv = new SinhVienDTO(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5),  rs.getString(6));
                listSV.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
               rs.close();
               sm.close();
               con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSV;
    }
    public void Insert(SinhVienDTO sv){
        con = getConnection();
        PreparedStatement ps  = null;
        try {
            ps = con.prepareStatement("insert into sinhvien(name,date_of_birth,phone,gender,address) values (?,?,?,?,?)");
            ps.setString(1, sv.getHoten());
            ps.setString(2, sv.getNamsinh());
            ps.setString(3, sv.getSdt());
            ps.setString(4, sv.getGioitinh());
            ps.setString(5, sv.getDiachi());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        public void update(SinhVienDTO sv){
        con = getConnection();
        PreparedStatement ps  = null;
        try {
            ps = con.prepareStatement("update sinhvien set name = ?,date_of_birth=?,phone=?,gender=?,address=? where id = ?");
            ps.setString(1, sv.getHoten());
            ps.setString(2, sv.getNamsinh());
            ps.setString(3, sv.getSdt());
            ps.setString(4, sv.getGioitinh());
            ps.setString(5, sv.getDiachi());
            ps.setInt(6, sv.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
          public void delete(SinhVienDTO sv){
        con = getConnection();
        PreparedStatement ps  = null;
        try {
            ps = con.prepareStatement("delete from sinhvien  where id = ?");
           
            ps.setInt(1, sv.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
          public List<SinhVienDTO>Search(SinhVienDTO s){
        List<SinhVienDTO> listSV = new ArrayList<>();
        con = getConnection();
        Statement sm = null;
        ResultSet rs  = null;
        try {
            sm = con.createStatement();
            rs = sm.executeQuery("select * from sinhvien where name = '"+s.getHoten()+"'");
            while(rs.next()){
                SinhVienDTO sv = new SinhVienDTO(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5),  rs.getString(6));
                listSV.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
               rs.close();
               sm.close();
               con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
      return listSV;
    }
    
}
