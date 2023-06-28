package zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Zdarzenia extends JFrame implements ActionListener{
    
    public Zdarzenia(){
        super("Zdarzenia");
        this.setBounds(300,300,300,200);
        
        initComponents();
        
        this.setDefaultCloseOperation(3);
    }
    
    public void initComponents(){
        kolorCzerwony = new JButton("Czerwony");
        kolorZolty = new JButton("Zolty");
        kolorZielony = new JButton("Zielony");
        kolorCzarny = new JButton("Czarny");
        kolorBialy = new JButton("Bialy");
        kolorSzary = new JButton("Szary");
        
        
        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));
        kolorZolty.addActionListener(new sluchaczKolorow(Color.YELLOW));
        kolorZielony.addActionListener(new sluchaczKolorow(Color.GREEN));
        kolorCzarny.addActionListener(new sluchaczKolorow(Color.BLACK));
        kolorBialy.addActionListener(new sluchaczKolorow(Color.WHITE));
        
        kolorSzary.addActionListener(this);
        
        panel.add(kolorCzerwony);
        panel.add(kolorZolty);
        panel.add(kolorZielony);
        panel.add(kolorCzarny);
        panel.add(kolorBialy);
        panel.add(kolorSzary);
        
        budujButton("rozowy", Color.PINK);
        
        
        this.getContentPane().add(panel);
        
    }
    
    JPanel panel = new JPanel();
    JButton kolorCzerwony;
    JButton kolorZolty;
    JButton kolorZielony;
    JButton kolorCzarny;
    JButton kolorBialy;
    JButton kolorSzary;
    
    public void budujButton(String nazwa,final Color k)
    {
        JButton przycisk = new JButton(nazwa);
        
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                panel.setBackground(k);
            }
        });

        
        panel.add(przycisk);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kolorSzary)
            panel.setBackground(Color.GRAY);
    }
    
    
    private class sluchaczKolorow implements ActionListener
    {
        public sluchaczKolorow(Color k)
        {
            this.kolor =k;
        }
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(kolor);
        }
        Color kolor;
    }
    
    public static void main(String[] args) {
    new Zdarzenia().setVisible(true);
    }
    
}
