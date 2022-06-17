/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mytabbedpanedemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author duykhai
 */
public class MyTabbedPaneDemo extends JFrame {

    public MyTabbedPaneDemo(String title) {
        super(title);
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon1 = createImageIcon("images/delete.gif");
        ImageIcon icon2 = createImageIcon("images/save.gif");
        ImageIcon icon3 = createImageIcon("images/new.gif");
        ImageIcon icon4 = createImageIcon("images/modify.gif");
        MyPanel1 panel1 = new MyPanel1("Panel #1");
        tabbedPane.addTab("Tab 1", icon1, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        MyPanel1 panel2 = new MyPanel1("Panel #2");
        tabbedPane.addTab("Tab 2", icon2, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        MyPanel1 panel3 = new MyPanel1("Panel #3");
        tabbedPane.addTab("Tab 3", icon3, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        MyPanel1 panel4 = new MyPanel1(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", icon4, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        //Add the tabbed pane to this panel.
        mainPanel.add(tabbedPane);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setBounds(350, 200, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        new MyTabbedPaneDemo("Demo TabbedPane Demo");

    }

    private static class TabbedPaneDemo {

        public TabbedPaneDemo() {
        }
    }

    class MyPanel1 extends JPanel {

        public MyPanel1(String text) {
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            this.setLayout(new GridLayout(1, 1));
            this.add(filler);
        }
    }

}
