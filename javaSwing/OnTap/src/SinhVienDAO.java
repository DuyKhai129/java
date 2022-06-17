
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class SinhVienDAO {

    static String url = "jdbc:mysql://localhost:3306/ontap";
    static String user = "root";
    static String pass = "";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return conn;
    }

    public static List<SinhVien> getAll() {
        List<SinhVien> listSV = new ArrayList<>();
        String query = "select * from sinhvien";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();//cung cấp các phương thức để thực thi các câu lệnh truy vấn với cơ sở dữ liệu SQL. Statement interface là một nhà máy của ResultSet, tức là nó cung cấp phương thức để tạo ra đối tượng ResultSet.
            ResultSet rs = stmt.executeQuery(query);//là một hành đối tượng rằng có những kết quả của thực hiện một lệnh truy vấn.

            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listSV.add(sv);
            }
        } catch (Exception e) {
        }
        return listSV;
    }

    public static void insert(SinhVien sv) {
        String query = "insert into sinhvien(name,date_of_birth,phone,gender,address) values (?,?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);//PreparedStatement được sử dụng để thực thi các câu truy vấn SQL động hoặc có tham số.
            pstmt.setString(1, sv.getName());
            pstmt.setString(2, sv.getDate_of_birth());
            pstmt.setString(3, sv.getPhone());
            pstmt.setString(4, sv.getGender());
            pstmt.setString(5, sv.getAddress());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void update(SinhVien sv) {
        String query = "update sinhvien set name=?,date_of_birth=?,phone=?,gender=?,address=? where id=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sv.getName());
            pstmt.setString(2, sv.getDate_of_birth());
            pstmt.setString(3, sv.getPhone());
            pstmt.setString(4, sv.getGender());
            pstmt.setString(5, sv.getAddress());
            pstmt.setInt(6, sv.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void delete(SinhVien sv) {
        String query = "delete  from sinhvien  where id=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, sv.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}
