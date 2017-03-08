package pl.mariusz.zagala.classes;

import pl.mariusz.zagala.datebase.Datebase;
import pl.mariusz.zagala.panels.LoginPanel;

import javax.swing.*;

/**
 * Created by MariuszZ on 2017-03-07.
 */
public class Main {
    public static void createAndShowGui()
    {
        //klasa ktora odpowiada za okienkow
        JFrame frame = new JFrame("BUTTONS");
        //dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tworzyy obiekt naszej klasy Okienko
        LoginPanel panel = new LoginPanel(frame);
        //ustawiamy panel na widoczny
        panel.setVisible(true);
        //ustawiamy zawartosc panelu jako glowna zawartosc okienka
        frame.setContentPane(panel);
        //pack to metoda ktora dopasuje rozmiar okineka do elementow ktore sie  wnim znajduja
        frame.pack();
        //frame.setSize(new Dimension(300,400));
        //ustawiamy widocznosc okienka na true
        frame.setVisible(true);
        //mozemy rozciagac okienko
        frame.setResizable(false);
        //dodajemy do jframea menu ktore pochodzi z formularza
        //frame.setJMenuBar(panel.createMenu());
    }
    public static void main(String[] args) {

        Word w = new Word("C:\\Users\\MariuszZ\\Desktop\\java_zadania\\_03_Learning_English\\Words.txt");
        Datebase.connect();
        Datebase.createTables();

        javax.swing.SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        createAndShowGui();
                    }
                }
        );
    }
}
