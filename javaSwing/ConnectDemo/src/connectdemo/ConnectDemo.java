/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author duykhai
 */
public class ConnectDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "")) {
            System.out.println("kết nỗi thành công");
            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
