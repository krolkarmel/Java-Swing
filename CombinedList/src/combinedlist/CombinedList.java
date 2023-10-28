package combinedlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinedList extends JFrame{
    public CombinedList(){
        initComponents();
    }
    
    public void initComponents(){
        this.setTitle("Listy kombinowane.");
        this.setBounds(300,300,300,200);
        
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorHandler handler = (ColorHandler)((JComboBox)e.getSource()).getSelectedItem();
                
                ((JPanel)(e.getSource())).setBackground(handler.getColor());
            }
        });
        
        panel.add(lista);
        
        lista.addItem(new ColorHandler("Czarny", Color.BLACK));
        lista.addItem(new ColorHandler("Biały", Color.WHITE));
        lista.addItem(new ColorHandler("Zielony", Color.GREEN));
        lista.addItem(new ColorHandler("Czerwony", Color.RED));
        lista.addItem(new ColorHandler("Pomarańczowy", Color.ORANGE));
        lista.addItem(new ColorHandler("Zółty", Color.YELLOW));
        lista.addItem(new ColorHandler("Niebieski", Color.BLUE));

        

        
        
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(3);
    }
    private class ColorHandler
            {
                public ColorHandler(String colorName, Color kolor){
                    this.kolor = kolor;
                    this.colorName = colorName;
                }
                public String toString(){
                    return this.colorName;
                }
                public Color getColor(){
                    return this.kolor;
                }
                
                private Color kolor;
                private String colorName;
            }
            
            
            
    private JPanel panel = new JPanel();
    JComboBox lista = new JComboBox();
    
    public static void main(String[] args) {
        new CombinedList().setVisible(true);
    }
}
