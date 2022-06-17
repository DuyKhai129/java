/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class RunX implements Runnable {

    private String prefix = "";

    public RunX(String p) {
        prefix = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(prefix + i);
        }
    }
}
