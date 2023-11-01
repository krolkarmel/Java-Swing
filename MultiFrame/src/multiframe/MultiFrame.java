package multiframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiFrame extends JFrame{
        public MultiFrame(){
            initComponents();
        }
        
        
        public void initComponents(){
            this.setTitle("MultiFrame");
            this.setBounds(300,300,300,200);
            
            panel.add(frame);
            
            frame.setPreferredSize(new Dimension(180,100));
            
            frame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        new dialog(taRamka).setVisible(true);
                }
            });
            
            this.getContentPane().add(panel, BorderLayout.SOUTH);
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private JFrame taRamka = this;
        JPanel panel = new JPanel();
        private JButton frame = new JButton("Otworz ramke");
        
    public static void main(String[] args) {
        new MultiFrame().setVisible(true);
    }
    
}
