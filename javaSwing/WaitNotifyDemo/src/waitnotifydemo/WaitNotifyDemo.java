/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package waitnotifydemo;

import java.util.logging.Level;
import java.util.logging.Logger;

class Q {

    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
            wait();
        } catch (InterruptedException e) {
        }

        System.out.println("Got: " + n);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Q.class.getName()).log(Level.SEVERE, null, ex);
        }
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        try {
            while (valueSet)
                try {
                wait();
            } catch (InterruptedException e) {
            }
            this.n = n;
            valueSet = true;
            System.out.println("Put: " + n);
            Thread.sleep(500);
            notify();
        } catch (InterruptedException ex) {
            Logger.getLogger(Q.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Producer implements Runnable {

    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {

    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class WaitNotifyDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }

}
