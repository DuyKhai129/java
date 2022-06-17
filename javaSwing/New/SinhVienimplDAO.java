/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.New;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SinhVienimplDAO implements SinhVienDAO{

    private String urlDB, userName, passWord;
    private String diverName = "com.mysql.jdbc.Driver";
    private String selectall = "select * from sinhvien";
    private String sqlInsert = "Insert into sinhvien (hoten,diachi,tenlop,namsinh) values (?,?,?,?)";
    private String sqlUpdate = "update sinhvien set hoTen=?,diaChi=?,tenLop=?,namSinh=? where id=?";
    private String sqlDelete = "delete from SINHVIEN where ID=?";
    private String sqlFindByID = "select * from sinhvien  where id=?";
    private String sqlFindByName = "select *from sinhvien where hoTen=?";

    public SinhVienimplDAO(String _urlDB, String _userName, String _passWord) {
        this.urlDB = _urlDB;
        this.userName = _userName;
        this.passWord = _passWord;
        try {
            Class.forName(diverName);
        } catch (ClassNotFoundException e1) {
            System.out.println("loi driver");
            e1.printStackTrace();
        }
    }

    private static void  closeConnec(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private Connection getConnection() {
        try {           
            return DriverManager.getConnection(urlDB, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return null;
    }

    public ArrayList<SinhVien> getAllSinhVien() {

        Connection con = getConnection();
        Statement st = null;
        ArrayList<SinhVien> listAll = new ArrayList<SinhVien>();
        ResultSet rs = null;
        if (con != null) {
            try {
                st = con.createStatement();
                rs = st.executeQuery(selectall);
                while (rs.next()) {
                    SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    listAll.add(sv);
                }                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeResultSet(rs);
                closeStatement(st);
                closeConnec(con);                
            }
        }
        return listAll;
    }

    public void insert(SinhVien sv) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        if (con != null) {
            try {
                pr = con.prepareStatement(sqlInsert);
                //  pr.setInt(1, _id);
                pr.setString(1, sv.getHoTen());
                pr.setString(2, sv.getDiaChi());
                pr.setString(3, sv.getTenLop());
                pr.setString(4, sv.getNamSinh());
                System.out.println(pr.toString());
                pr.executeUpdate();
                pr.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            } finally {                
                closeConnec(con);
            }

        }
    }

    public void updateSinhVien(SinhVien sv) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlUpdate);
            pr.setString(1, sv.getHoTen());
            pr.setString(2, sv.getDiaChi());
            pr.setString(3, sv.getTenLop());
            pr.setString(4, sv.getNamSinh());
            pr.setInt(5, sv.getId());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeConnec(con);
        }
    }

    public boolean DeleteSinhVien(SinhVien sv) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        int k = 0;
        try {
            pr = con.prepareStatement(sqlDelete);
            pr.setInt(1, sv.getId());
            k = pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            closeConnec(con);
        }
        if (k > 0) {
            return true;
        }
        return false;
    }

    public SinhVien findSinhVienByID(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                rs.close();
                return sv;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnec(con);
        }
    }

    public SinhVien findByName(String name) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByName);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                rs.close();
                stmt.close();
                return sv;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnec(con);
        }
    }

    public void showData() {
        ArrayList<SinhVien> listSinhVien = getAllSinhVien();
//        for(int i=0;i<listSinhVien.size();i++)
//        {SinhVien sv=listSinhVien.get(i);
//            System.out.println(sv.toString());
//        }
        for (SinhVien sv : listSinhVien) {
            System.out.println(sv.toString());
        }

    }

    public static void main(String args[]) {
        SinhVienimplDAO demo = new SinhVienimplDAO("jdbc:mysql://localhost:3306/mydatabase", "root", "admin");

        SinhVien sv = new SinhVien("Tran Van Khai1", "Tan Thinh Thai Nguyen", "K19AKTPM", "2002");
        // demo.insert(sv);
       // SinhVien svXoa = demo.findSinhVienByID(2);
        
        demo.showData();
        //demo.DeleteSinhVien(svXoa);
        System.out.println("Sau khi xoa sinh vien thu 2");
        demo.showData();
        SinhVien svSua=demo.findByName("abc");
        svSua.setHoTen("To Huu Nguyen 1");
       demo.updateSinhVien(svSua);
       System.out.println("Sau khi sua ");
        demo.showData();
//        ResultSet r=demo.getData();
//         if(r!=null){
//             System.out.println("du lieu sau khi insert");
//             demo.showData(r);
//         }
    }
}
