package windowaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowAction extends JFrame implements WindowListener {
    public WindowAction(){
        initComponents();
    }
    
    public void initComponents(){
        this.setTitle("Pola Wyboru");
        this.setBounds(300,300,300,200);
        
      //  this.addWindowListener(new WindowAdapter() {});
        this.addWindowListener(this);
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    
    
    
    
    
    
    
    

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Witaj");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcja = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz zamknac program?");        
        if(opcja == 0){
        this.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Zegnaj");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Wroc szybko!");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Jestem spowrotem");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Jestem aktywny");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Jestem nieaktywny");
    }
    public static void main(String[] args) {
            
            new WindowAction().setVisible(true);
    }
}
