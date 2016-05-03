package ch.hslu.ta.prg2.view;

import javax.swing.*;

/**
 *
 */
public class mainframe extends JFrame {

    //Constants
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_LENGTH = 1200;

    public mainframe() {

        //CREATE STARTPANEL
        startpanel startpanel = new startpanel(WINDOW_HEIGHT,WINDOW_LENGTH);

        
        //ADD THINGS
        this.add(startpanel);
       
        //SET OPTIONS
        this.setBounds(100, 100, WINDOW_LENGTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
