/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tinhdientichclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author duykhai
 */
public class TinhDienTichClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tạo ra một socket để kết nối với Server

        try {
            Socket connectServer;
            connectServer = new Socket("DESKTOP-I6QJMI9", 90);
            
            //tạo ra một luồng dữ liệu để nhận dữ liệu nguyên thủy từ Server;
            DataInputStream input = new DataInputStream(connectServer.getInputStream());
            
            // Tạo ra một luồng dữ liệu để gửi dữ liệu nguyên thủy đến Client
            DataOutputStream output = new DataOutputStream(connectServer.getOutputStream());
            
            // liên tục nhận, xử lý kết quả và gửi cho Server
            Scanner read = new Scanner(System.in);
            while (true) {
                System.out.print(" Nhập bán kính: ");
                double banKinh = read.nextDouble();
                output.writeDouble(banKinh);
                output.flush();
                
                // nhận kết quả từ Server
                double dienTich = input.readDouble();
                System.out.println(" Diện tích nhận dược từ server: " + dienTich);
            }
        } catch (UnknownHostException e) {

        } catch (IOException e1) {

        } catch (Exception e2) {

        }
    }
}
