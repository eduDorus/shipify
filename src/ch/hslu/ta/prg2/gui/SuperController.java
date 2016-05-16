package ch.hslu.ta.prg2.gui;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 */
public class SuperController {

    static MainFrame mainframe;
    static StartPanel startpanel;
    static HomePanel homepanel;

    public SuperController() {
        createMainFrame();
        createStartPanel();
    }

    private void createMainFrame() {
        mainframe = new MainFrame();
    }

    private static void addPanel(JPanel panel) {
        mainframe.add(panel);
        mainframe.repaint();
    }

    private void createStartPanel() {
        startpanel = new StartPanel();
        addPanel(startpanel);
    }

    private static void createHomePanel() {
        homepanel = new HomePanel();
        addPanel(homepanel);
    }

    public static void startButtonActionListener() {
        createHomePanel();
        mainframe.remove(startpanel);
        addPanel(homepanel);
  }

}
