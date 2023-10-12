package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame{
    
public Menu()
{
    initComponents();
}

public void initComponents()
{
    this.setTitle("Menu");
    this.setBounds(200  ,200,500,400);
    
    panelMenu.setLayout(new GridLayout(3,1));
    panelMenu.add(menu1);
    panelMenu.add(menu2);
    panelMenu.add(menu3);
    
    kontener.add(panelMenu);
    this.setDefaultCloseOperation(3);
}

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    
    private MenuButton menu1 = new MenuButton("1.Dodaj");
    private MenuButton menu2 = new MenuButton("2.Usun");
    private MenuButton menu3 = new MenuButton("3.Zatwierdz");
    
    private int i = 0;

    
    private class MenuButton extends JButton implements FocusListener, ActionListener
    {
    public MenuButton(String nazwa)
    {
        super(nazwa);
        this.addFocusListener(this);
        this.addActionListener(this);
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                keyPressedHandler(e);
            }

        });
        this.setBackground(kDefault);
    }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(kFocusGained);
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(kDefault);
        }
        private void keyPressedHandler(KeyEvent e){
            int dlMenu = panelMenu.getComponentCount();
            
            if (i==0) i  = 10*dlMenu;
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
            //    System.out.println(i++);
                panelMenu.getComponent(++i%dlMenu).requestFocus();
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                System.out.println(i--);
                panelMenu.getComponent(i%dlMenu).requestFocus();
            }
            else if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                ((MenuButton)e.getSource()).doClick();
            }
        }
        
        private Color kFocusGained = Color.RED;
        private Color kDefault = Color.BLUE;

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText());
        }
    }
    
    
    
    public static void main(String[] args) {
    new Menu().setVisible(true);
    }
    
}
