package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 */
public class HomePanel extends JPanel {

    //COMPONENTS
    JButton btn_LOCAL;
    JButton btn_LAN;

    public HomePanel() {

        this.setSize(1227, 800);

        createComponents();

        addObjects();
        setOptions();

    }

    //CREATE OBJECTS
    private void createComponents() {

        btn_LOCAL = new JButton("Neues Spiel gegen den PC");
        btn_LAN = new JButton("Neues Spiel über LAN");

    }

    //SET OPTIONS        
    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 20);

        btn_LOCAL.setFont(font1);
        btn_LAN.setFont(font1);

        btn_LOCAL.setBounds(450, 300, 300, 50);
        btn_LAN.setBounds(450, 400, 300, 50);

        btn_LOCAL.addActionListener((ActionEvent e) -> {
            GUIController.localButtonClicked();
        });

        btn_LAN.addActionListener((ActionEvent e) -> {
            GUIController.lanButtonClicked();
        });
    }

    private void addObjects() {;
        this.add(btn_LOCAL);
        this.add(btn_LAN);

    }

}
