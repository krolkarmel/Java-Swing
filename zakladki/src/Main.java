import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }


    public void initComponents() {
        this.setTitle("Zakladki");
        this.setBounds(300, 300, 900, 800);

        JPanel panel = new JPanel();
        panel.add(new JButton("buttonTestowy"));

        zakladki.addTab("beznazwy1", new JLabel("Pierwszy Tab"));
        zakladki.setMnemonicAt(0, KeyEvent.VK_T);




        zakladki.addTab("beznazwy1", new ImageIcon("xd.png"), new JLabel("Drugi Tab"));
        zakladki.addTab("beznazwy1", new ImageIcon("xd.png"), panel);
        zakladki.addTab("to jest drugi tab", panelTworzenia);

        panelTworzenia.add(new JLabel("Stworz nowy plik o nazwie: "));
        JTextField nazwaNowejZakladki = new JTextField(7);
        panelTworzenia.add(nazwaNowejZakladki);
        JButton stworzZakladke = new JButton("Stworz");
        panelTworzenia.add(stworzZakladke);


        stworzZakladke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelTekstowy = new JPanel();
                panelTekstowy.setLayout(new GridLayout(1,1));
                JTextArea obszarTekstowy = new JTextArea();
                panelTekstowy.add(new JScrollPane(obszarTekstowy));
                zakladki.addTab(nazwaNowejZakladki.getText()+".txt", panelTekstowy);

                zakladki.setSelectedIndex(zakladki.getTabCount()-1);

                obszarTekstowy.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (!(tytulZakladki + e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar()) && flagaZapisu) {
                            przedZmianaObszaruTekstowego = tytulZakladki + e.getKeyChar();
                            zakladki.setTitleAt(indexZakladka, tytulZakladki+ "*");
                            flagaZapisu = false;
                        }
                        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && !flagaZapisu){
                            zakladki.setTitleAt(indexZakladka, tytulZakladki);
                            System.out.println("Zapisujemy");
                            flagaZapisu = true;
                        }

                    }

                    String przedZmianaObszaruTekstowego = "";
                    int indexZakladka = zakladki.getSelectedIndex();
                    String tytulZakladki = zakladki.getTitleAt(indexZakladka);
                    boolean flagaZapisu = true;
                    private boolean czyToAscii(char zn){
                        for(int i = 0 ; i <256; i++){
                            if (zn == i)
                                return true;
                        }
                        return false;
                    }
                });



            }
        });

        zakladki.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.getContentPane().add(zakladki);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTabbedPane zakladki = new JTabbedPane();
    private JPanel panelTworzenia = new JPanel();


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}