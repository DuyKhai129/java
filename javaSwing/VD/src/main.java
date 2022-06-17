/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duykhai
 */
public class main {

    public static void main(String args[]) {
        //VD1
        Luong1 L1 = new Luong1("Luong 1");
        Luong1 L3 = new Luong1("luong 3");
        Luong2 r2 = new Luong2("luong 2");
        Thread L2 = new Thread(r2);
        L2.setName("abc");
        System.out.println("L 1" + L2.getName());
        L1.start();
        L2.start();
        L3.start();
        //VD2
        ThreadX t1 = new ThreadX("Luồng thứ 1:");
        ThreadX t2 = new ThreadX("Luồng thứ 2:");
        ThreadX t3 = new ThreadX("Luồng thứ 3:");
        t1.setName("Luong 1");
        t2.setName("Luong 2");
        t3.setName("Luong 3");
        System.out.println("ID luồng 1:" + t1.getId());
        System.out.println("ID luồng 2:" + t2.getId());
        System.out.println("ID luồng 3:" + t3.getId());
        System.out.println("Tên luồng 1:" + t1.getName());
        System.out.println("Tên luồng 2:" + t2.getName());
        System.out.println("Tên luồng 3:" + t3.getName());
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(1);
        t2.setPriority(5);
        t1.start();
        t2.start();
        t3.start();
        //VD3
        RunX p1 = new RunX("Luồng thứ 1:");
        RunX p2 = new RunX("Luồng thứ 2:");
        RunX p3 = new RunX("Luồng thứ 3:");
        RunX p4 = new RunX("Luồng thứ 4:");
        Thread k1 = new Thread(p1);
        Thread k2 = new Thread(p2);
        Thread k3 = new Thread(p3);
        Thread k4 = new Thread(p4);
        k1.start();
        k2.start();
        k3.start();
        k4.start();
        //VD11
        Lop11 d1 = new Lop11();
        Lop12 d2 = new Lop12();
        Thread Lg1 = new Thread(d1);
        Thread Lg2 = new Thread(d2);
        Lg1.start();
        Lg2.start();
    }
}
