package pl.mariusz.zagala.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MariuszZ on 2017-03-08.
 */
public class MainPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private AddWordsPanel addWordsPanel;
    private SearchWordsPanel searchWordsPanel;
    private LearningPanel learningPanel;

    private JMenuItem menuItemaddWordsPanel;
    private JMenuItem menuItemsearchWordsPanel;
    private JMenuItem menuItemlearningPanel;

    public MainPanel() {

        super(new CardLayout());

        addWordsPanel = new AddWordsPanel();
        searchWordsPanel = new SearchWordsPanel();
        learningPanel = new LearningPanel();

        menuItemaddWordsPanel = new JMenuItem("Words");
        menuItemaddWordsPanel.addActionListener(this);
        menuItemlearningPanel = new JMenuItem("Learning");
        menuItemlearningPanel.addActionListener(this);
        menuItemsearchWordsPanel = new JMenuItem("Serach words");
        menuItemsearchWordsPanel.addActionListener(this);

        add(addWordsPanel, "Add Words");
        add(searchWordsPanel, "Search Words");
        add(learningPanel, "Learning");
    }

    public JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("FORMULARZE");
        menu.add(menuItemaddWordsPanel);
        menu.add(menuItemlearningPanel);
        menu.add(menuItemsearchWordsPanel);
        menuBar.add(menu);
        return menuBar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemsearchWordsPanel)
        {
            CardLayout cL = (CardLayout)getLayout();
            cL.show(this, "serach");
        }
    }
}
