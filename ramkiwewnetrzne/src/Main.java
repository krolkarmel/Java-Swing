import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Ramki wewnetrzne");
        this.setBounds(300,300,300,200);

        JInternalFrame wewnetrznaRamka = new JInternalFrame("tytul", true, true, true);
        wewnetrznaRamka.add(new JButton("testtt"));
        wewnetrznaRamka.setVisible(true);
        wewnetrznaRamka.pack();

        JInternalFrame wewnetrznaRamka2 = new JInternalFrame("tytul", true, true, true);
        wewnetrznaRamka2.add(new JLabel("testowa etykieta"));
        wewnetrznaRamka2.setVisible(true);
        wewnetrznaRamka2.pack();

        wewnetrznaRamka.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        wewnetrznaRamka.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("otwarte");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
            String odp= JOptionPane.showInternalInputDialog(e.getInternalFrame(), "Wpisz wyjscie by wyjsc z programu lub zamknij by zamknac ramke");
            if(odp != null)
                if(odp.equals("wyjscie")){
                    System.exit(0);
                }
            else if(odp.equals("zamknij")){
                e.getInternalFrame().dispose();
                }
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("zamkniecie");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("zikonizowana");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
                System.out.println("deikonizowana");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                System.out.println("aktywacja");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
                System.out.println("dezaktywacja");
            }
        });

        desktopPane.add(wewnetrznaRamka);
        desktopPane.add(wewnetrznaRamka2);

        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private JDesktopPane desktopPane = new JDesktopPane();
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
