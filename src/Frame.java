import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(Panel panel){
        super();
        this.add(panel);
        this.getContentPane().setPreferredSize(new Dimension(panel.getSize().width,panel.getSize().height));
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-panel.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-panel.getSize().height/2);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
