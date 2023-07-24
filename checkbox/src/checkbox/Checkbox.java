package checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checkbox extends JFrame{
public Checkbox()
{
    initComponents();
}

    public void initComponents()
    {
        this.setTitle("Pole Wyboru");
        this.setBounds(300,300,300,200);
        
        etykieta.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        ActionListener sluchacz = new CheckboxHandler();
        
        pogrubiony.addActionListener(sluchacz);
        pochylony.addActionListener(sluchacz);

        panel1.add(pogrubiony);
        panel1.add(pochylony);
        
        panel2.add(etykieta);
        
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(3);
        
    }
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    JCheckBox pogrubiony = new JCheckBox("Pogrubiony");
    JCheckBox pochylony = new JCheckBox("Pochylony");
    
    JLabel etykieta = new JLabel("Jestem elegancki");
    
    
    public class CheckboxHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            int style = Font.PLAIN;
            
            if(pogrubiony.isSelected()) style += Font.BOLD;
            if(pochylony.isSelected()) style += Font.ITALIC;
            
            etykieta.setFont(new Font(etykieta.getFont().getFamily(), style, etykieta.getFont().getSize()));
        }   
    }
    public static void main(String[] args) {
        new Checkbox().setVisible(true);
        
    }
    
}
