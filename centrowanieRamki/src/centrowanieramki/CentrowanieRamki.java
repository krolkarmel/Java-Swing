package centrowanieramki;

import java.awt.*;
import javax.swing.JFrame;

public class CentrowanieRamki extends JFrame{
    public CentrowanieRamki()
    {
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        this.setSize(szer/10, wys/4);
        
//        this.setLocation(szer/4, wys/4);

        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
        
        this.setLocation((szer-szerRamki)/2, (wys-wysRamki)/2);
        
        this.setDefaultCloseOperation(3);

        
    }
    public static void main(String[] args) {


        new CentrowanieRamki().setVisible(true);

    }
    
}
