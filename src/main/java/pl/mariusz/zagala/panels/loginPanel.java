package pl.mariusz.zagala.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MariuszZ on 2017-03-08.
 */
public class loginPanel extends JPanel implements ActionListener {
    private  JButton btnLogin;
    private JButton btnCancel;
    private JTextField tfUser;
    private JPasswordField tfPassword;
    private JLabel lUser;
    private JLabel lPassword;
    private JButton btnCreate;
    private JFrame frame;

    public loginPanel(JFrame frame)
    {
        super(new GridLayout(4,2,8,8));
        this.frame = frame;
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);
        btnCreate = new JButton("Create");
        btnCreate.addActionListener(this);

        lPassword = new JLabel("Password");
        lUser = new JLabel("User");

        tfPassword = new JPasswordField(12);
        tfUser = new JTextField(10);

        add(lUser);
        add(tfUser);
        add(lPassword);
        add(tfPassword);
        add(btnLogin);
        add(btnCancel);
        add(btnCreate);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnLogin)
        {
            String PasswordGod = "a";// połączenie do bazy danych w celu sprawdzenia czy takie hałos i user jest w bazie;
            String userGod = "a";//

            String User = tfUser.getText();
            char[] Password = tfPassword.getPassword();
            String modifiedPassword = String.valueOf(Password);

            if (PasswordGod.equals(modifiedPassword) && userGod.equals(User))
            {

                JFrame frameGlowny = new JFrame("Login");
                frameGlowny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainPanel panel = new mainPanel();
                panel.setVisible(true);
                frameGlowny.setContentPane(panel);
                frameGlowny.pack();
                frameGlowny.setVisible(true);
                frameGlowny.setResizable(false);
                frameGlowny.setJMenuBar(panel.createMenu());
                frame.dispose();
            }
        }

		else if(e.getSource() == btnCancel)
        {
        frame.dispose();
        }

    }

}

