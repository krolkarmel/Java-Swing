
package clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends JFrame{
    public Clock(){
    super("Zegar");
    this.setBounds(300,300,300,200);
    
    
    initComponents();
    
    this.setDefaultCloseOperation(3);
    }
    
    
    public void initComponents()
    {
//        panel.add(etykieta);
        panel.add(czas);
        
        ActionListener stoper = new czas();
        
        this.getContentPane().add(panel);
        
        Timer zegar = new Timer(1000, stoper);
        
        zegar.start();
        
        pack();
    }
    
    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Czas: ");
    JLabel czas = new JLabel(pobierzCzas());
    
    
    private class czas implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    static int i = 1;
    
    
    public String pobierzCzas()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
            
            
            String h = ""+kalendarz.get(Calendar.HOUR_OF_DAY);
            String m = ""+kalendarz.get(Calendar.MINUTE);
            String s = ""+kalendarz.get(Calendar.SECOND);
            
            if(Integer.parseInt(h) < 10){
                h= "0" + h;
            }
            if(Integer.parseInt(m) < 10){
                m= "0" + m;
            }
            if(Integer.parseInt(s) < 10){
                s= "0" + s;
            }
        return h+":"+m+":"+s;
    }
    public static void main(String[] args) {
        new Clock().setVisible(true);
    }
}
