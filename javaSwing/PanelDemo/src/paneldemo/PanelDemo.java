
package paneldemo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JFrame;

/**
 *
 * @author duykhai
 */
public class PanelDemo extends JFrame {
   Button next, prev, fist;
        public PanelDemo(String sTile){
             super(sTile);       //
        next = new Button("Next>>");
        prev = new Button("<<Prev");
        fist = new Button("Fist");
        Panel southPanel = new Panel();
        southPanel.add(next);
        southPanel.add(prev);
        southPanel.add(fist);
        this.add(southPanel, BorderLayout.SOUTH);
        Panel northPanel = new Panel();
        northPanel.add(new Label("Make a selection"));
        this.add(northPanel, BorderLayout.NORTH);
        List li = new List();
        for (int i = 0; i < 10; i++) {
            li.add("Selection" + i);
        }
        this.add(li, BorderLayout.CENTER);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public static void main(String[] args) {
       JFrame f = new PanelDemo("Panel Demo");
        f.setSize(300, 200);
        f.setVisible(true);
    }
    
}
