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
        menuPlik.setMnemonic('P');

        Action actionSave = new ActionSave("ZAPISZ", "ZAPISUJEMY","ctrl s", new ImageIcon("pobrane.png"), KeyEvent.VK_Z);
        final JMenuItem podMenuZapisz = new JMenuItem(actionSave);

        button = new JButton(actionSave);

        JMenuItem podMenu = menuPlik.add(new JMenuItem("Nowy"));
        JMenu test = menu.add(new JMenu("test"));
        podMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KLIK!");
            }
        });
        menuPlik.addSeparator();
        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();

        JMenu menuOpcje = new JMenu("OPCJE");
        menuPlik.add(menuOpcje);

        menuOpcje.add(new JMenuItem("Opcja 1."));
        menuOpcje.add(new JMenuItem("Opcja 2."));
        menuOpcje.add(odczyt);
        JMenu menuPomoc = menu.add(new JMenu("POMOC"));

        menuPomoc.add(new JMenuItem("FAQ"));

        podMenuZapisz.setEnabled(false);
      //  podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        actionSave.setEnabled(false);
 //       podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S));

/*
        odczyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(odczyt.isSelected()){
                    podMenuZapisz.setEnabled(false);
                }
                else{
                    podMenuZapisz.setEnabled(flagaObszaruTekstowego);
                }
            }
        });
*/
        obszarTekstowy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (odczyt.isSelected()) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (odczyt.isSelected()) {
                    e.consume();
                } else if (!(obszarTekstowy.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar())) {
                    przedZmianaObszaruTekstowego = obszarTekstowy.getText()+e.getKeyChar();
                    actionSave.setEnabled(flagaObszaruTekstowego = true);
                }
                System.out.println(obszarTekstowy.getText() + e.getKeyChar());
            }
        });

        podMenuZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ZAPISANE NA DYSKU");

                podMenuZapisz.setEnabled(flagaObszaruTekstowego == false);
            }
        });

  //      podMenuZapisz.setToolTipText("Zapisano pliki");
  //      podMenuZapisz.setMnemonic('z');
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(obszarTekstowy);
        this.getContentPane().add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar menu = new JMenuBar();
    private JCheckBoxMenuItem odczyt = new JCheckBoxMenuItem("Tylko do Odczytu");
    private JRadioButtonMenuItem radio = new JRadioButtonMenuItem();
    private JTextArea obszarTekstowy = new JTextArea();
    private boolean flagaObszaruTekstowego = false;
    private String przedZmianaObszaruTekstowego = "";
    private boolean czyToAscii(char zn){
        for(int i = 0 ; i <256; i++){
            if (zn == i)
                return true;
        }
        return false;
    }
    private JButton button;

    private class ActionSave extends AbstractAction{
    ActionSave(String nazwa, String podpowiedz, String klawiaturowySkrot, Icon ikona, int mnemonicKey){
        this.putValue(Action.NAME, nazwa);
        this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
        this.putValue(Action.SMALL_ICON, ikona);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ZAPISANE NA DYSKU");

            this.setEnabled(flagaObszaruTekstowego == false);
        }
    }
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}