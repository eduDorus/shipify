package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class SaveGamePanel extends JPanel {

    JButton btn_delGame;
    JButton btn_newGame;
    JButton btn_selectGame;
    JButton btn_back;
    JList list_savedGamesList;

    public SaveGamePanel() {
        this.setSize(1227, 800);

        createComponents();
        addObjects();
        setOptions();

    }

    private void createComponents() {

        btn_delGame = new JButton("Spiel löschen");
        btn_selectGame = new JButton("Spiel starten");
        btn_newGame = new JButton("Neues Spiel");
        btn_back = new JButton("Zurück");
        list_savedGamesList = new JList();
    }

    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 20);

        btn_delGame.setFont(font1);
        btn_selectGame.setFont(font1);
        btn_newGame.setFont(font1);
        btn_back.setFont(font1);

        list_savedGamesList.setBounds(75, 75, 1050, 450);

        btn_back.setBounds(75, 600, 206, 50);
        btn_selectGame.setBounds(356, 600, 206, 50);
        btn_delGame.setBounds(631, 600, 206, 50);
        btn_newGame.setBounds(911, 600, 206, 50);
        btn_back.addActionListener((ActionEvent e) -> {
            GUIController.backSaveGamePanelActionListener();
        });
//        btn_delGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });
//        btn_selectGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });
        btn_newGame.addActionListener((ActionEvent e) -> {
            GUIController.newGameButtonActionListener();
        });
    }

    private void addObjects() {

        this.add(list_savedGamesList);
        this.add(btn_delGame);
        this.add(btn_selectGame);
        this.add(btn_newGame);
        this.add(btn_back);
    }
}
