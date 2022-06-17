/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pcsyn;

class Q1 {

    int n;

//    synchronized 
    int get() {
        System.out.println("Got: " + n);
        return n;
    }

//    synchronized 
    void put(int _n) {
        this.n = _n;
        System.out.println("Put: " + n);
    }
}

class Producer1 implements Runnable {

    Q1 q;

    Producer1(Q1 q) {
        this.q = q;
        // new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                q.put(i);
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
        }
    }
}

class Consumer1 implements Runnable {

    Q1 q;

    Consumer1(Q1 q) {
        this.q = q;
        //new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                q.get();
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
        }

    }
}

public class PCSyn {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        Producer1 pro1 = new Producer1(q1);
        Consumer1 con1 = new Consumer1(q1);
        Thread luong1 = new Thread(pro1);
        Thread luong2 = new Thread(con1);
        luong1.start();
        luong2.start();
        System.out.println("Press Control-C to stop.");
    }

}
