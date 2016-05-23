package ch.hslu.ta.prg2.gui;

import javax.swing.*;

/**
 *
 */
public class MainFrame extends JFrame {

    //Constants
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_LENGTH = 1200;

    public MainFrame() {

        //CREATE STARTPANEL
        setOptions();

    }

    //SET OPTIONS
    private void setOptions() {

        this.setBounds(100, 100, WINDOW_LENGTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //ADD THINGS
}
