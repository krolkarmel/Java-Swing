import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame{
    public Main(){
        initComponents();
    }

    public void initComponents(){
        this.setTitle("Pasek Menu");
        this.setBounds(300,300,300,200);

        this.setJMenuBar(menu);

        JMenu menuPlik = menu.add(new JMenu("Plik"));
        JMenuItem podMenu = menuPlik.add(new JMenuItem("Nowy"));
        JMenu test = menu.add(new JMenu("test"));
        podMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KLIK!");
            }
        });
        menuPlik.addSeparator();
        JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();

        JMenu menuOpcje = new JMenu("OPCJE");
        menuPlik.add(menuOpcje);

        menuOpcje.add(new JMenuItem("Opcja 1."));
        menuOpcje.add(new JMenuItem("Opcja 2."));
        menuOpcje.add(odczyt);
        JMenu menuPomoc = menu.add(new JMenu("POMOC"));

        menuPomoc.add(new JMenuItem("FAQ"));

        odczyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(odczyt.isSelected()){
                    podMenuZapisz.setEnabled(false);
                }
                else{
                    podMenuZapisz.setEnabled(true);
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar menu = new JMenuBar();
    private JCheckBoxMenuItem odczyt = new JCheckBoxMenuItem("Tylko do Odczytu");

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}