/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demmosapxep;

import javax.swing.JFrame;

class SapxepTang extends Thread {

    int MT[];

    SapxepTang(int M[]) {
        MT = M;
    }

    public void setData(int M[]) {
        MT = M;
    }

    @Override
    public void run() {
        for (int i = 0; i < MT.length - 1; i++) {
            for (int j = i + 1; j < MT.length; j++) {
                if (MT[j] < MT[i]) {
                    int tg = MT[j];
                    MT[j] = MT[i];
                    MT[i] = tg;

                }
                System.out.println("run luong 1");
            }
        }
    }

    synchronized int[] getData() {
        return MT;
    }
}

class SapxepGiam extends JFrame implements Runnable {

    int MG[];

    SapxepGiam(int M[]) {
        MG = M;
    }

    @Override
    public void run() {

        for (int i = 0; i < MG.length - 1; i++) {
            for (int j = i + 1; j < MG.length; j++) {
                if (MG[j] > MG[i]) {
                    int tg = MG[j];
                    MG[j] = MG[i];
                    MG[i] = tg;

                }
                System.out.println("run luong 2");
            }
        }
    }

    synchronized int[] getData() {
        return MG;
    }

}

public class DemMoSapxep {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int M[] = {2, 6, 1, 4, 7, 1};
        int M1[] = {5, 2, 1, 2, 9, 6};
        SapxepTang L1 = new SapxepTang(M);
        SapxepGiam r2 = new SapxepGiam(M1);
        Thread L2 = new Thread(r2);
        L1.start();
        L2.start();
        try {
            System.out.println("Waiting for threads to finish.");
            L1.join();
            L2.join();
        } catch (InterruptedException e) {
        }
        int MT[] = L1.getData();
        int MG[] = r2.getData();

        for (int i = 0; i < MT.length; i++) {
            System.out.print(MT[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < MG.length; i++) {
            System.out.print(MG[i] + " ");
        }
    }

}
