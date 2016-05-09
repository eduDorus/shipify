package ch.hslu.ta.prg2.view;

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
        StartPanel startpanel = new StartPanel(WINDOW_HEIGHT, WINDOW_LENGTH);

        setOptions();

        addObjects(startpanel);
    }

    //SET OPTIONS
    private void setOptions() {

        this.setBounds(100, 100, WINDOW_LENGTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //ADD THINGS
    private void addObjects(StartPanel startpanel) {

        this.add(startpanel);

    }

}
