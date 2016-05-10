package ch.hslu.ta.prg2.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 */
public class StartPanel extends JPanel {

    //COMPONENTS
    JButton btn_start;
    JLabel lbl_declareName;
    JTextField txt_nameField;

    public StartPanel(int WINDOW_HEIGHT, int WINDOW_LENGTH) {

        this.setSize(WINDOW_HEIGHT, WINDOW_LENGTH);

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
        this.setLayout(new BorderLayout());

//        lbl_declareName.setBounds(800, 800, 100, 50);
//        txt_nameField.setBounds(0, 0, 100, 100);
//        btn_start.setBounds(400, 400, 1000, 1000);
    }

    private void addObjects() {
        this.add(lbl_declareName);
        this.add(txt_nameField);
        this.add(btn_start);

    }

}
