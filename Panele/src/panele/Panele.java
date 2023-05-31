package panele;

import javax.swing.*;
import java.awt.*;

public class Panele extends JFrame{
    public Panele(){
         this.setBounds(300,300,300,200);
         
         initComponents();
         
         this.setDefaultCloseOperation(3);
        }
    
    public void initComponents()
    {
        
        button1.setPreferredSize(new Dimension(100,100));
        button2.setPreferredSize(button2.getPreferredSize());
        panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        
        this.getContentPane().add(panel1, BorderLayout.CENTER);
        
        
        
    }
    JPanel panel1 = new JPanel(new FlowLayout((FlowLayout.CENTER)));
    
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    
    public static void main(String[] args) {
        
        new Panele().setVisible(true);


    }
    
}
