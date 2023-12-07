import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;


public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Spinners");
        this.setBounds(300, 300, 300, 200);

        String[] miesiace = new DateFormatSymbols().getMonths();
        //   for(int i = 0 ; i < miesiace.length ; i++)
        //   System.out.println(miesiace[i]);

        JPanel panel = new JPanel();

        Calendar kalendarz = Calendar.getInstance();

        Date poczatkowaWartosc = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, -20);
        Date minimalnaWartosc = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, +40);
        Date maksymalnaWartosc = kalendarz.getTime();

        MySpinnerListModel modelMiesiecy = new MySpinnerListModel(cutArray(miesiace,0,11));
        SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 5, 2);
        SpinnerDateModel modelDat = new SpinnerDateModel(poczatkowaWartosc, minimalnaWartosc, maksymalnaWartosc, Calendar.DAY_OF_MONTH);


        JSpinner spinner = new JSpinner(modelMiesiecy);
        JSpinner spinner2 = new JSpinner(modelLiczb);
        JSpinner spinner3 = new JSpinner(modelDat);
        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);

        // spinner.setEditor(new JTextArea("lalaa"));


        this.getContentPane().add(panel, BorderLayout.NORTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MySpinnerListModel extends SpinnerListModel {
        public MySpinnerListModel(Object[] wartosci) {
            super(wartosci);
            firstValue = wartosci[0];
            lastValue = wartosci[wartosci.length - 1];
        }

        public Object getNextValue() {
            if (super.getNextValue() == null) {
                return firstValue;
            }
            return super.getNextValue();
        }

        public Object getPreviousValue() {
            if (super.getPreviousValue() == null) {
                return lastValue;
            } else {
                return super.getPreviousValue();
            }
        }

        Object firstValue, lastValue;

    }
    private Object[] cutArray(Object[] operowany, int poczatek, int koniec) {
        koniec = koniec > operowany.length -1  || koniec < 0 ? operowany.length -1: koniec;
        poczatek = poczatek < 0 || poczatek > koniec ? 0 : poczatek;

        Object [] temp = new Object[koniec + 1 - poczatek];

        for(int i = poczatek, j=0 ; i < koniec+1; i++, j++ ){
            temp[j] = operowany[i];
        }

        return temp;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}