package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author dias
 */
public class SaveGamePanel extends JPanel {

    JButton btn_delGame;
    JButton btn_newGame;
    JButton btn_selectGame;

    JList list_savedGamesList;

    public SaveGamePanel() {
        this.setSize(1200, 800);

        createComponents();

        addObjects();
        setOptions();

    }

    //CREATE OBJECTS
    private void createComponents() {

        btn_delGame = new JButton("Spiel löschen");
        btn_selectGame = new JButton("Spiel starten");
        btn_newGame = new JButton("Neues Spiel");

    }

    //SET OPTIONS        
    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 20);

        btn_delGame.setFont(font1);
        btn_selectGame.setFont(font1);
        btn_newGame.setFont(font1);

        btn_delGame.setBounds(450, 200, 300, 50);
        btn_selectGame.setBounds(450, 300, 300, 50);
        btn_newGame.setBounds(450, 400, 300, 50);

//        btn_delGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });
//        btn_selectGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });
//        btn_newGame.addActionListener((ActionEvent e) -> {
//            SuperController.startButtonActionListener();
//        });

    }

    private void addObjects() {
        this.add(btn_delGame);
        this.add(btn_selectGame);
        this.add(btn_newGame);

    }

}
