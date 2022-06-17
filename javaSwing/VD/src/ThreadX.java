/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class ThreadX extends Thread {

    private String ten = "";

    public ThreadX(String p) {
        ten = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(ten + i);
            System.out.println("Do uu tien" + this.getPriority());
            System.out.println();
        }
    }
}
