
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
//có thể được truy cập trực tiếp thông qua lớp mà không cần khởi tạo.
public  class SinhVienController {
      
    
       public static Connection getConnection(){
           Connection con = null;
           try {
               //nạp driver
              Class.forName("com.mysql.jdbc.Driver");//phân mềm chung fian giúp ngôn ngữ giao tiếp đc vs csql
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ontap", "root", "");
               System.out.println("Kết nối thành công");
               System.out.println(con.getCatalog());
           } catch (Exception e) {
               System.out.println("lỗi kết nỗi ko thành công");
               e.printStackTrace();
           }
           return con;
       }
       public static List<SinhVienModel>getAll(){
           List<SinhVienModel> listSV = new ArrayList<>();
           String query = "select * from sinhvien";
           try {
               Connection con = getConnection();
               Statement st = con.createStatement();//một thực thi hướng dẫn mà nói với các biên dịch những gì để thực hiện.
               ResultSet rs = st.executeQuery(query);
               while(rs.next()){
                   SinhVienModel sv = new SinhVienModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                   listSV.add(sv);
               }
               rs.close();
               st.close();
               con.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return listSV;
       }
       public static void insert(SinhVienModel sv){
           String query = "insert into sinhvien(name,date_of_birth,phone,gender,address) values (?,?,?,?,?)";
           try {
               Connection con = getConnection();
               PreparedStatement ps = con.prepareStatement(query);
               ps.setString(1, sv.getHoten());
               ps.setString(2, sv.getNamsinh());
               ps.setString(3, sv.getSdt());
               ps.setString(4, sv.getGioitinh());
               ps.setString(5, sv.getDiachi());
               ps.executeUpdate();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       public static void update(SinhVienModel sv){
            String query = "update sinhvien set name = ?,date_of_birth=?,phone=?,gender=?,address=? where id = ?";
           try {
               Connection con = getConnection();
               PreparedStatement ps = con.prepareStatement(query);
               ps.setString(1, sv.getHoten());
               ps.setString(2, sv.getNamsinh());
               ps.setString(3, sv.getSdt());
               ps.setString(4, sv.getGioitinh());
               ps.setString(5, sv.getDiachi());
               ps.setInt(6, sv.getId());
               ps.executeUpdate();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       public static void delete(SinhVienModel sv){
            String query = "delete from sinhvien where id = ?";
           try {
                Connection con = getConnection();
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1, sv.getId());
               ps.executeUpdate();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
}
