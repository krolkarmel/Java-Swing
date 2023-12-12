import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame {
    public Main(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Podzielone panele");
        this.setBounds(300,300,300,200);

        JSplitPane podzielenie = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListy, panelObrazka);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    Obrazek img = (Obrazek)((JList)e.getSource()).getSelectedValue();

                    obrazek.setIcon(img.getImage());
                    opis.setText(img.getDescription());
                }
            }
        });

        panelListy.add(lista);
        panelObrazka.add(obrazek);
        panelOpisu.add(opis);

        JSplitPane podzielenieGlowne = new JSplitPane(JSplitPane.VERTICAL_SPLIT, podzielenie, panelOpisu);

        this.getContentPane().add(podzielenieGlowne);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JPanel panelListy = new JPanel();
    JPanel panelObrazka = new JPanel();
    JPanel panelOpisu = new JPanel();
    JList lista = new JList(new Obrazek[]{
            new Obrazek("zielony", "piekny kolor zielony"),
            new Obrazek("czarny", "piekny kolor czerwony"),
            new Obrazek("niebieski", "piekny kolor niebieski")
    });
    JLabel obrazek = new JLabel();
    JLabel opis = new JLabel();

    private class Obrazek{
        String nazwa, opis;
        ImageIcon obrazek;
        public Obrazek(String nazwa, String opis){
            this.nazwa = nazwa;
            this.opis = opis;

            obrazek =new ImageIcon(nazwa + ".png");
        }
        public String toString(){
            return nazwa;
        }
        public ImageIcon getImage(){
            return obrazek;
        }
        public String getDescription(){
            return opis;
        }
    }
    public static void main(String[] args) {
     new Main().setVisible(true);

    }
}