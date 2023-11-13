package suwak;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Suwak extends JFrame{

   public Suwak(){
            initComponents();
        }
        
        
        public void initComponents(){
            this.setTitle("SUWAK");
            this.setBounds(300,300,300,200);
               
            this.getContentPane().add(suwak, BorderLayout.NORTH);
            this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH);
            this.getContentPane().add(tekst, BorderLayout.CENTER);
            
            suwak.setMajorTickSpacing(5);
            suwak.setPaintTicks(true);
            suwak.setPaintLabels(true);
            suwak.setSnapToTicks(true);
            
            suwak.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    wartoscSuwaka.setText(""+((JSlider)e.getSource()).getValue());
               
                    tekst.setFont(new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(),((JSlider)e.getSource()).getValue()));
                    
                }
            });
            
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        JSlider suwak = new JSlider(0 , 50 , 25);
        JTextField wartoscSuwaka = new JTextField(""+suwak.getValue());
        JLabel tekst = new JLabel("cosiek");
        
        public static void main(String[] args) {
        new Suwak().setVisible(true);
    }
    
}