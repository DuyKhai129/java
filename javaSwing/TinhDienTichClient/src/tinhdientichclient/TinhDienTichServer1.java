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
public class TinhDienTichServer1 {

    public static void main(String args[]) {
        int stt = 0;
        try {
            //tạo ra Server socket;
            ServerSocket serversocket = new ServerSocket(90);
            
            // lắng nghe yêu cầu kết nối từ server
            while (true) {
                System.out.println("Chờ kết nối....");
                Socket socketconnectClient = serversocket.accept();
                
                //tạo ra một luồng dữ liệu để nhận dữ liệu nguyên thủy từ Client;
                StuffThread stuff = new StuffThread(socketconnectClient, ++stt);
                stuff.start();
            }
        } catch (IOException e) {

        }
    }
}

class StuffThread extends Thread {

    int stt;
    private final Socket socket;

    public StuffThread(Socket _socket, int _stt) {
        socket = _socket;
        stt = _stt;
    }

    @Override
    public void run() {
        System.out.println("Accepted Client : ID " + stt + "  Address - "
                + socket.getInetAddress().getHostName());
        try {
            //tạo ra một luồng dữ liệu để nhận dữ liệu nguyên thủy từ Client;
            DataInputStream input = new DataInputStream(socket.getInputStream());
            
            // Tạo ra một luồng dữ liệu để gửi dữ liệu nguyên thủy đến Client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            
            // liên tục nhận, xử lý kết quả và gửi cho Client
            while (true) {
                
                // đọc một số Double từ Client
                double banKinh = input.readDouble();
                System.out.println("Ban kinh nhan tu Client co ID" + stt + ":  + " + banKinh);
                double dienTich = banKinh * banKinh * Math.PI;
                
                // gửi trả kết quả cho Client;           
                output.writeDouble(dienTich);
                output.flush();
                System.out.println("Dien tich hinh tron co ban kinh "
                        + banKinh + " dien tich la" + dienTich);
            }
        } catch (IOException e) {

        }
    }
}
