/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author duykhai
 */
public class ChatServer extends JFrame {
    
      private JButton btnListen, btnSend;
    private JTextField txtPort, txtMessage;
    private JTextPane txpMessagerBoard;
    
    private ChatSocket chatSocket;

    public ChatServer(String title) throws HeadlessException {
        super(title);
        initcomponents();
        event();
        
    }
     private void initcomponents() {
       this.setSize(650, 650);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       this.setAlwaysOnTop(true);// giúp dừng JFrame khi ta click chuột vào trong code thì nó vẫn đứng im
       
       //pnTittle
       JPanel pnTitle = new JPanel();
       JLabel lbTitle = new JLabel("Chát Sever");
       lbTitle.setFont(new Font("Tomaho",Font.BOLD,20));
       lbTitle.setForeground(Color.red);
       pnTitle.add(lbTitle);
       this.getContentPane().add(pnTitle,BorderLayout.NORTH);
        //pnCenter
        JPanel pnCenter = new JPanel(new BorderLayout());
        //pnNorthC
        JPanel pnNorthC = new JPanel(new GridLayout(1, 3, 5, 5));
        txtPort  = new JTextField("9888");
        txtPort.enable(false);
        btnListen = new JButton("Listen");
        pnNorthC.add(new JLabel("Port:"));
        pnNorthC.add(txtPort);
        pnNorthC.add(btnListen);
         pnCenter.add(pnNorthC,BorderLayout.NORTH);
        //pnCenterC
        JPanel pnCenterC= new JPanel(new BorderLayout());
        txpMessagerBoard = new JTextPane();
        txpMessagerBoard.setSize(100,100);
        pnCenterC.add(txpMessagerBoard);
            pnCenter.add(pnCenterC,BorderLayout.CENTER);
            this.getContentPane().add(pnCenter,BorderLayout.CENTER);
        //pnSouth
        JPanel pnSouth = new JPanel(new GridLayout(1,3,5,5));
        txtMessage  = new JTextField(90);
        btnSend = new JButton("Send");
        pnSouth.add(new JLabel("Message:"));
        pnSouth.add(txtMessage);
        pnSouth.add(btnSend);
        this.getContentPane().add(pnSouth,BorderLayout.SOUTH);
        
        
        
        
    }
     public void event(){
         btnListen.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     int port = Integer.parseInt(txtPort.getText());
                     ServerSocket serverSocket = new ServerSocket(port);
                     
                     Thread th = new Thread(){
                         public void run(){
                             try {
                             txpMessagerBoard.setText(txpMessagerBoard.getText()+"\nListening...");
                            Socket socket = serverSocket.accept();//lắn nghe
                            chatSocket =  new ChatSocket(socket,txpMessagerBoard);
                             } catch (Exception e) {
                                 txpMessagerBoard.setText("\nError"+e.getMessage());
                                 e.printStackTrace();
                             }
                         }
                     };
                     th.start();
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
                     ex.printStackTrace();
                 }
             }
         });
         btnSend.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(txtMessage.getText().equals("")){
                     return;
                 }
                 chatSocket.send(txtMessage.getText());
             }
         });
     }
     public static void main(String[] args) {
        new ChatServer("Quản lý Server").setVisible(true);
    }
    
}
