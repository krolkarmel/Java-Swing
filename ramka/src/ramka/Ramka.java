package ramka;
import javax.swing.*;
import java.awt.*;
public class Ramka extends JFrame{
    public Ramka(){
        /*
//tworzenie ramki
        JFrame frame = new JFrame("SALON AUDI");
//        frame.setTitle("Program ultra");

//rozmiar
//        frame.setSize(100,200);
//        frame.setSize(new Dimension(100,100));



//lokacja
//        frame.setLocation(40,20);
//        frame.setLocale(new Point(100,200));
        
        
        //lokacja i rozmiar
        
        frame.setBounds(100,100,500,700);
        
        
        //poruszanie ramka tak nie
        frame.setResizable(false);
        
        //ikonka
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("audi.jpg"));
        
        
        
//      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        
        */
        // super("tytul ramki");
        this.setTitle("Program audi");
        this.setSize(500,500);
        this.setLocation(new Point(50,30));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("audi.jpg"));
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
//        this.pack();
    }
    public static void main(String[] args) {
        new Ramka().setVisible(true);
    }
    
}

