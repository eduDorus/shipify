package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.mediator.Server;
import javax.swing.JPanel;

/**
 *
 */
public class GUIController {

    static MainFrame mainframe;
    static StartPanel startpanel;
    static HomePanel homepanel;
    static SaveGamePanel savegamepanel;
    static LanGamePanel langamepanel;
    static GameBoardPanel gameboardpanel;
    private static String playername;

    public GUIController() {
        createMainFrame();
        createStartPanel();
    }

    private void createMainFrame() {
        mainframe = new MainFrame();
    }

    private static void addPanel(JPanel panel) {
        mainframe.add(panel);
//        mainframe.setVisible(true);
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

    private static void createLanGamePanel() {
        langamepanel = new LanGamePanel();
    }
    
    private static void createGameBoardPanel(){
        gameboardpanel = new GameBoardPanel();
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
        createLanGamePanel();
        mainframe.remove(homepanel);
        addPanel(langamepanel);
    }

    static void backLanGamePanelActionListener() {
        mainframe.remove(langamepanel);
        addPanel(homepanel);
    }

    static void newGameButtonActionListener() {
        createGameBoardPanel();
        mainframe.remove(langamepanel);
        addPanel(gameboardpanel);
        Server.getInstance().newGame(playername);
    }
}
