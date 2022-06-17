/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author duykhai
 */
public class ChatSocket {
    private Socket socket;
    private JTextPane txtMessagerBoard;//hiển thị thông tin nhận gửi
    private PrintWriter out;//gởi dữ liệu đi
    private BufferedReader reader;//nhận dữ liệu thông qua socket

    public ChatSocket(Socket socket, JTextPane txtMessagerBoard) throws IOException {
        this.socket = socket;
        this.txtMessagerBoard = txtMessagerBoard;
        
    out = new PrintWriter(socket.getOutputStream());
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
    receive();
    }

    ChatSocket(Socket socket, JTextArea txtChatArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void receive(){
        Thread th = new Thread(){
            public void run(){
                while(true){
                    try {
                        //đọc 1 dòng dữ liệu
                        String line = reader.readLine();
                        if(line != null){
                            txtMessagerBoard.setText(txtMessagerBoard.getText() + "\n >>> " +line);
                        }
                    } catch (Exception e) {
                    }
                }
            }
             
        };
           th.start();    
    }
    public void send(String mag){
        String current = txtMessagerBoard.getText();
        txtMessagerBoard.setText(current + "\nsend: " +mag);
        out.println(mag);//gửi một dòng dữ liệu
        out.flush();//đổ dữ liệu đi
    }
    //đóng các luồng dữ liệu
    public void close(){
        try {
            out.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    
}
