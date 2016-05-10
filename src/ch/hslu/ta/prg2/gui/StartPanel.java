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

    public StartPanel() {

        this.setSize(1200, 800);

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

        lbl_declareName.setBounds(800, 800, 100, 50);
        txt_nameField.setBounds(0, 0, 100, 100);
        btn_start.setBounds(400, 400, 200, 50);
    }

    private void addObjects() {
        this.add(lbl_declareName);
        this.add(txt_nameField);
        this.add(btn_start);

    }

}