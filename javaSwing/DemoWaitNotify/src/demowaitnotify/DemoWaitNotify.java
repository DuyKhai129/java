/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demowaitnotify;

class Customer {
    int amount = 10000; 
    synchronized void withdraw(int amount) {
        System.out.println("Rút tiền...:Số tiền đang có la:"+this.amount);
        
        if (this.amount < amount) {
            System.out.println("Tài khoản không đủ; đợi gửi tiền...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("Hoàn thành rút tiền!:Số tiền còn lại: "+this.amount);
    }
 
    synchronized void deposit(int amount) {
        System.out.println("Gửi tiền...");
        this.amount += amount;
        System.out.println("Hoàn thành gửi tiền!");
        notify();
    }
}
public class DemoWaitNotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Customer c = new Customer();
        new Thread() {
            @Override
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
    
}
