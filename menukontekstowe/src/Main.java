import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Menu Kontekstowe");
        this.setBounds(300,300,300,200);

        JPopupMenu menuKontekstowe = new JPopupMenu();

        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));

        this.getContentPane().add(test, BorderLayout.SOUTH);
        this.getContentPane().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");

                if (e.getClickCount() == 10 && e.getButton() == MouseEvent.BUTTON1) {
                    JOptionPane.showMessageDialog(rootPane, "Kliknales 10 razy lewym przyciskiem");
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private JButton test = new JButton("test");


    public static void main(String[] args) {
        new Main().setVisible(true);
        }
}