package ch.hslu.ta.prg2.gui;

import javax.swing.JPanel;

/**
 *
 */
public class SuperController {

    MainFrame mainframe;

    public SuperController() {

        createMainFrame();

    }

    private void createMainFrame() {

        mainframe = new MainFrame();

    }

    protected void addPanel(JPanel panel) {
        mainframe.add(panel);

    }

}
