import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
    public Main(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Listy");
        this.setBounds(300,300,300,200);
        //String [] nazwa = new String[] ("lala", "hmmmm");

        listaPrzedmiotow.setVisibleRowCount(3);
      //  listaPrzedmiotow.setFixedCellHeight(40);
      //  listaPrzedmiotow.setFixedCellWidth(150);
        listaPrzedmiotow.setSelectionBackground(Color.CYAN);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN);

       // listaPrzedmiotow.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Zmienilem sie"+(++i));

                if(e.getValueIsAdjusting())
                    System.out.println("Trzymam przycisk myszy");
                else
                    System.out.println("Puscilem przycisk myszy");

                if(!e.getValueIsAdjusting()){
                    Object[] wartosciWLiscie =((JList)e.getSource()).getSelectedValues();

                    String przedmioty = "";

                    for(int i =0 ; i< wartosciWLiscie.length; i++) {
                        przedmioty += (String) wartosciWLiscie[i] + " ";

                    }
                    System.out.println(przedmioty);
                    komunikat.setText("Te przedmioty lubie: " + przedmioty);
                }
            }
        });

        // JList lista2 = new JList (new String[] {"k", "t", "a", "s"});
        DefaultListModel modelListy = new DefaultListModel();

        String[] tekst =  new String[]{"Matematyka", "Fizyka", "Informatyka", "Chemia", "Biologia", "WOS"};

        modelListy.addElement("C");
        modelListy.addElement("A");
        modelListy.addElement("X");
        modelListy.addElement("Y");

        JList lista3 = new JList(modelListy);
        lista3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                for(int i = 0 ; i < tekst.length ; i++){
                    modelListy.addElement(tekst[i]);
                }
           //     modelListy.remove(0);
            }
        });

        panelListy.add(scrollLista);
        panelKomunikatu.add(komunikat);

        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.getContentPane().add(lista3, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int i = 0;
    private JList listaPrzedmiotow = new JList(new String[]{"Matematyka", "Fizyka", "Informatyka", "Chemia", "Biologia", "WOS"});
    private JScrollPane scrollLista = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel("lalalallala");
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}