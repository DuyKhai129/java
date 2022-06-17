
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class ConnJDBC {
   

    public static Connection getConnection() {// connection function
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhansu", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static List<NhanVien>findAll(){
        List<NhanVien>listNV = new ArrayList<>();
        String query = "select * from nhanvien";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();//cung cấp các phương thức để thực thi các câu lệnh truy vấn với cơ sở dữ liệu SQL. Statement interface là một nhà máy của ResultSet, tức là nó cung cấp phương thức để tạo ra đối tượng ResultSet.
            ResultSet rs = stmt.executeQuery(query);//là một hành đối tượng rằng có những kết quả của thực hiện một lệnh truy vấn.
            //kiểm tra nếu phia trc = đ thì chạy còn = s thì dừng
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listNV.add(nv);
            }
        } catch (Exception e) {
        }
        return listNV;
    }
    public static void insert(NhanVien nv){
        String query = "insert into nhanvien(hoten,namsinh,sodienthoai,chucvu) values (?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);//PreparedStatement được sử dụng để thực thi các câu truy vấn SQL động hoặc có tham số.
            pstmt.setString(1,nv.getHoTen());
            pstmt.setString(2,nv.getNamsinh());
            pstmt.setString(3,nv.getSodienthoai());
            pstmt.setString(4,nv.getChucvu());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
     public static void update(NhanVien nv){
         String query = "update nhanvien set hoTen=?,namsinh=?,sodienthoai=?,chucvu=? where id=?";
         try {
             Connection conn = getConnection();
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nv.getHoTen());
            pstmt.setString(2,nv.getNamsinh());
            pstmt.setString(3,nv.getSodienthoai());
            pstmt.setString(4,nv.getChucvu());
             pstmt.setInt(5, nv.getId());
            pstmt.executeUpdate();
         } catch (Exception e) {
         }
     }
     public static void delete(NhanVien nv){
          String query = "delete from nhanvien where id=?";
          try {
             Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
              pstmt.setInt(1, nv.getId());
             pstmt.executeUpdate();
         } catch (Exception e) {
         }
     }
      public static List<NhanVien>findByName(NhanVien h) {
         List<NhanVien>listNV = new ArrayList<>();
        String query = "select * from nhanvien where hoten ='"+h.getHoTen()+"'";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            //kiểm tra nếu phia trc = đ thì chạy còn = s thì dừng
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listNV.add(nv);
            }
        } catch (Exception e) {
        }
        return listNV;
    }
}

