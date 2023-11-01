package multiframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JDialog{
        public MyFrame(JFrame parent){
            initComponents();
            
        int szer = (int)parent.getBounds().getWidth();
        int wys = (int)parent.getBounds().getHeight();
        
    //    this.setSize(szer/10, wys/4);
        
//        this.setLocation(szer/4, wys/4);

        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
        
        this.setLocation(parent.getBounds().x+(szer-szerRamki)/2, (parent.getBounds().y+(wys-wysRamki)/2));
        }
        
        
        public void initComponents(){
            this.setTitle("MultiFrame NR - " + (++i));
            this.setBounds(300,300,250,100);
         
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
    public static void main(String[] args) {
        new MultiFrame().setVisible(true);
    }
    static int i = 0;
}
