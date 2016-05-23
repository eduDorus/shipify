package ch.hslu.ta.prg2.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_LENGTH = 1200 + 27;

    public MainFrame() {
        setOptions();
    }

    private void setOptions() {
        this.setBounds(100, 100, WINDOW_LENGTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
