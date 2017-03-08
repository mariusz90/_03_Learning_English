package pl.mariusz.zagala.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MariuszZ on 2017-03-08.
 */
public class mainPanel extends JPanel implements ActionListener {


    public mainPanel() {
        super(new CardLayout());
        addWords = new addWords();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("FORMULARZE");
        menu.add
    }
}
