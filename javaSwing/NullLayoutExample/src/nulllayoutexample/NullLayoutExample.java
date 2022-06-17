/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nulllayoutexample;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author duykhai
 */
public class NullLayoutExample {
    public static void ShowNullLayOut()
    {
        Frame fr=new Frame("Null Layout Show");
        fr.setLayout(null);
        Button buttOK=new Button("OK");
        buttOK.setBounds(100, 150, 50, 30);
        Button buttCencel=new Button("Cencel");
        buttCencel.setBounds(200, 150, 50, 30);
        Checkbox check=new Checkbox("Check box",true);
        check.setBounds(100, 50, 100, 20);
        List li=new List();
        for(int i=0;i<=5;i++)
            li.add(Integer.toString(i));
        li.setBounds(200, 50, 50, 50);
        fr.add(buttOK);
        fr.add(buttCencel);
        fr.add(check);
        fr.add(li);
        fr.pack();
        fr.setBounds(200, 200, 500, 500);
        fr.addWindowListener(new WindowClose11());
        fr.setVisible(true);
    }
    public static void main(String args[])
    {
    ShowNullLayOut();
    }
}
class WindowClose11 extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
}
