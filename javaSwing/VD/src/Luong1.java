
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author duykhai
 */
public class Luong1 extends Thread {

    String ten;

    Luong1(String _ten) {
        ten = _ten;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 200; i++) {
            try {
                System.out.println("Luong " + ten + " xin chào: " + i);
                Thread.sleep(5);
                Thread.yield();
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Luong2 extends JFrame implements Runnable {

    String ten;

    Luong2(String _ten) {
        ten = _ten;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 200; i++) {
            try {
                double k = Math.pow(3, 7);
                System.out.println("Luong " + ten + " xin chào: " + i);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
    }
}
