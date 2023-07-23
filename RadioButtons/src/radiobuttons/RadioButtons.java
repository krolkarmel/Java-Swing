package radiobuttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtons extends JFrame{
public RadioButtons()
{
    initComponents();
}
    public void initComponents()
    {
        this.setTitle("Grupy Przełączników Radio");
        this.setBounds(300,300,300,200);
        panel2.add(etykieta);

        zbudujPrzelacznikRozmiar("maly", 15);
        zbudujPrzelacznikRozmiar("sredni", 45);
        zbudujPrzelacznikRozmiar("duzy", 125);
        
        zbudujPrzelacznikKolor("Zielony", Color.GREEN);
        zbudujPrzelacznikKolor("Czarny", Color.BLACK);
        zbudujPrzelacznikKolor("Czerwony", Color.RED);

        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        this.getContentPane().add(panel3, BorderLayout.CENTER);
        this.setDefaultCloseOperation(3);
    }
    
    public void zbudujPrzelacznikRozmiar(String nazwa,final int rozmiar)
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etykieta.setFont(new Font("Dialog", Font.BOLD, rozmiar));
            }
        });
    
    groupColor.add(przelacznik);
    panel3.add(przelacznik);
        
    }
    
    public void zbudujPrzelacznikKolor(String nazwa,final Color k)
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etykieta.setForeground(k);
            }
        });
    
    groupSize.add(przelacznik);
    panel.add(przelacznik);
        
    }
    
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("elo");
    ButtonGroup groupSize = new ButtonGroup();
    ButtonGroup groupColor = new ButtonGroup();
    
    public static void main(String[] args) {
        new RadioButtons().setVisible(true);
    }
    
}
