package searchtext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Searchtext extends JFrame {

    public Searchtext(){
        initComponents();
    }
    
    public void initComponents(){
        this.setTitle("Przeszukiwacz tekstu");
        this.setBounds(300,300,300,200);
        
        panelSzukania.add(szukany);
        panelSzukania.add(znajdz);
        panelSzukania.add(etykieta1);
        panelSzukania.add(zamien);
        panelSzukania.add(zamiana);
        
        
        
        //obszarTekstowy.selectAll();
        //obszarTekstowy.select(0,32);
        //obszarTekstowy.replaceSelection("lala");
        //obszarTekstowy.replaceRange("lala", 0 , 5);
        //obszarTekstowy.insert("Podmiana tekstu", 20);
        //obszarTekstowy.append("KONIEC");
        //obszarTekstowy.select(obszarTekstowy.getText().indexOf("test"),obszarTekstowy.getText().indexOf("test") + "test".length());
        
        znajdz.addActionListener(new znajdowanieHandler());
        zamien.addActionListener(new zamienianieHandler());
        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.SOUTH);
        //this.getContentPane().add(szukany, BorderLayout.CENTER);
        
        
        this.setDefaultCloseOperation(3);
    }
    private class zamienianieHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()){

                zmien();
            }
            else{
            znajdz.doClick(0);
            if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
                zmien();
        }
        }
        private void zmien() {
            obszarTekstowy.requestFocus();
            int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy chcesz zamienic " + szukany.getText() + "na " + zamiana.getText(), "Uwaga nastapi zamiana tekstu!" , JOptionPane.YES_NO_OPTION);
            if (opcja == 0)
            obszarTekstowy.replaceRange(zamiana.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
            
        }
    }
    private class znajdowanieHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(), poczatekSzukanego+szukany.getText().length());
        
            if(poczatekSzukanego == -1)
                poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());
            
            if(poczatekSzukanego >= 0 && szukany.getText().length() > 0){
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego+ szukany.getText().length());
          //  JOptionPane.showMessageDialog(null, poczatekSzukanego);
            
            }
           // else{
          //      JOptionPane.showMessageDialog(null, "Nie znaleziono");
           // }
        }
        
        
    }
    
    private int poczatekSzukanego = 0;
    private JTextArea obszarTekstowy = new JTextArea("To jest testowy tekst o testowym charakterze.");
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy);
    
    
    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdź");
    private JTextField szukany = new JTextField(4);
    private JLabel etykieta1 = new JLabel("I");
    private JButton zamien = new JButton("Zamień");
    private JTextField zamiana = new JTextField(4);
    
    
    
    public static void main(String[] args) {
        new Searchtext().setVisible(true);
    }
    
}
