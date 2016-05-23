package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.mediator.Server;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 */
public class GUIController {

    static MainFrame mainframe;
    static StartPanel startpanel;
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
        repaintFrame();
    }

    private void createStartPanel() {
        startpanel = new StartPanel();
        addPanel(startpanel);
    }

    private static void createSaveGamePanel() {
        savegamepanel = new SaveGamePanel();
    }

    private static void createLanGamePanel() {
        langamepanel = new LanGamePanel();
    }

    private static void createGameBoardPanel() {
        gameboardpanel = new GameBoardPanel();
    }

    public static void localButtonClicked() {
        if (startpanel.islblEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            createSaveGamePanel();
            mainframe.remove(startpanel);
            addPanel(savegamepanel);
            Server.getInstance().newBotGame(playername);
        }
    }

    public static void lanButtonClicked() {
        if (startpanel.islblEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            createLanGamePanel();
            mainframe.remove(startpanel);
            addPanel(langamepanel);
        }
    }

    static void backLanGamePanelActionListener() {
        mainframe.remove(langamepanel);
        addPanel(startpanel);
    }

    static void backSaveGamePanelActionListener() {
        mainframe.remove(savegamepanel);
        addPanel(startpanel);
    }

    static void newGameButtonActionListener() {
//        createGameBoardPanel();
//        mainframe.remove(langamepanel);
//        addPanel(gameboardpanel);
//        Server.getInstance().newGame(playername);
//         
//        TestGameBoard testgameboard = new TestGameBoard();
//
//        testgameboard.setVisible(true);

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                testgameboard.setVisible(true);
//            }
//        });
    }

    public static void repaintFrame() {
        mainframe.setVisible(true);
        mainframe.repaint();
    }

}
