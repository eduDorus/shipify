package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 */
public class LanGamePanel extends JPanel {

    JButton btn_back;
    JButton btn_newGame;
    JButton btn_connectGame;

    JList list_savedGamesList;

    public LanGamePanel() {
        this.setSize(1200, 800);

        createComponents();

        addObjects();
        setOptions();

    }

    //CREATE OBJECTS
    private void createComponents() {

        btn_back = new JButton("Zurück");
        btn_connectGame = new JButton("Verbinden");
        btn_newGame = new JButton("Neues Spiel");

        list_savedGamesList = new JList();
    }

    //SET OPTIONS        
    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 20);

        btn_back.setFont(font1);
        btn_connectGame.setFont(font1);
        btn_newGame.setFont(font1);

        list_savedGamesList.setBounds(75, 75, 1048, 450);

        btn_back.setBounds(75, 600, 300, 50);
        btn_connectGame.setBounds(450, 600, 300, 50);
        btn_newGame.setBounds(825, 600, 300, 50);
        btn_back.addActionListener((ActionEvent e) -> {
            GUIController.backLanGamePanelActionListener();
        });
//        btn_selectGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });
        btn_newGame.addActionListener((ActionEvent e) -> {
            GUIController.newGameButtonActionListener();
        });
    }

    private void addObjects() {

        this.add(list_savedGamesList);
        this.add(btn_back);
        this.add(btn_connectGame);
        this.add(btn_newGame);

    }
}
