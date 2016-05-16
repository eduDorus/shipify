package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 */
public class StartPanel extends JPanel {

    //COMPONENTS
    JButton btn_start;
    JLabel lbl_declareName;
    JTextField txt_nameField;

    public StartPanel() {


        createComponents();

        addObjects();
        setOptions();

    }

    //CREATE OBJECTS
    private void createComponents() {

        lbl_declareName = new JLabel("Bitte gib deinen Namen an:");
        txt_nameField = new JTextField();
        btn_start = new JButton("Start");

    }

    //SET OPTIONS        
    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 22);

        lbl_declareName.setFont(font1);

        btn_start.setFont(font1);

        txt_nameField.setFont(font1);

        lbl_declareName.setBounds(450, 200, 300, 50);
        txt_nameField.setBounds(450, 300, 300, 50);
        btn_start.setBounds(650, 400, 100, 50);
        btn_start.addActionListener((ActionEvent e) -> {

            GUIController.startButtonClicked();

        });
    }

    private void addObjects() {
        this.add(lbl_declareName);
        this.add(txt_nameField);
        this.add(btn_start);

    }

}
