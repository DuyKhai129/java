
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author duykhai
 */
public class Lop11 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 200; i++)
           try {
            Thread.sleep(500);
            System.out.println("Luong thuc thi lop 1 " + i);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lop11.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

class Lop12 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 200; i++) {

            try {
                Thread.sleep(500);
                System.out.println("Luong thuc thi lop 2 " + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lop11.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
