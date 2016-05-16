package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.mediator.Server;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 */
public class SuperController {

    static MainFrame mainframe;
    static StartPanel startpanel;
    static HomePanel homepanel;
    static SaveGamePanel savegamepanel;
    private static String playername;

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
    }

    private static void createSaveGamePanel() {
        savegamepanel = new SaveGamePanel();
    }

    public static void startButtonClicked() {
        createHomePanel();
        mainframe.remove(startpanel);
        addPanel(homepanel);
        playername = startpanel.txt_nameField.getText();
    }

    public static void localButtonClicked() {
        createSaveGamePanel();
        mainframe.remove(homepanel);
        addPanel(savegamepanel);
        Server.getInstance().newBotGame(playername);
    }

    public static void lanButtonClicked() {
        Server.getInstance().newGame(playername);
    }
}
