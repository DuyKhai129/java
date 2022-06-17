/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinhdientichclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author duykhai
 */
public class TinhDienTichServer {

    public static void main(String args[]) {
        try {
            //tạo ra Server socket;
            ServerSocket serversocket;
            serversocket = new ServerSocket(90);
            
            // lắng nghe yêu cầu kết nối từ server
            System.out.println(" Chờ kết nối....");
            
            //tạo erversocket.accept
            Socket socketconnectClient = serversocket.accept();
            System.out.println(" Có 1 Client kết nối đến.");
            
            
            DataInputStream input = new DataInputStream(socketconnectClient.getInputStream());

            // Tạo ra một luồng dữ liệu để gửi dữ liệu nguyên thủy đến Client
            DataOutputStream output = new DataOutputStream(socketconnectClient.getOutputStream());
            
            // liên tục nhận, xử lý kết quả và gửi cho Client
            while (true) {
                // đọc một số Double từ Client
                System.out.println(" Cho Client gửi dữ liệu....");
                double banKinh = input.readDouble();
                System.out.println(" Bán kính nhận từ Client: " + banKinh);
                double dienTich = banKinh * banKinh * Math.PI;
                
                // gửi trả kết quả cho Client;
                output.writeDouble(dienTich);
                output.flush();
                System.out.println(" Diện tích hình tròn có bán kính "+ banKinh + " diện tích là: " + dienTich);
            }
        } catch (IOException e) {

        }

    }
}
