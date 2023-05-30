package ukladgraficzny;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ukladgraficzny extends JFrame{

    public Ukladgraficzny()
    {
        super("Uklad graficzny (Layout)");
        this.setBounds(300,320,300,200);
        
        initComponents();
//        this.pack();
        this.setDefaultCloseOperation(3);
    }
    
    
    public void initComponents()
    {
        centrum = new JButton("Anuluj");
        gora = new JButton("Enter");
        left = new JButton("Cofnij");
        right = new JButton("Jestem na prawej!");
        down = new JButton("Jestem na dole!");
        
        Container kontener = this.getContentPane();
        
//        kontener.add(centrum, BorderLayout.CENTER);
//        kontener.add(gora, BorderLayout.PAGE_START);
//        kontener.add(left, BorderLayout.EAST);
//        kontener.add(right, BorderLayout.WEST);
//        kontener.add(down, BorderLayout.PAGE_END);
        

        gora.setLocation(10,100);
        gora.setSize(70,30);
        centrum.setLocation(110,100);
        centrum.setSize(70,30);
        left.setLocation(210,100);
        left.setSize(70,30);
        kontener.setLayout(null);
        kontener.add(centrum);
        kontener.add(gora);
        kontener.add(left);

    }
    
    JButton centrum;
    JButton gora;
    JButton left;
    JButton right;
    JButton down;
    public static void main(String[] args) {
        new Ukladgraficzny().setVisible(true);
    }
    
}
