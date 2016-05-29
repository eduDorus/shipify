package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.mediator.Server;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIController {

    static MainFrame mainframe;
    static StartPanel startpanel;
    static SaveGamePanel savegamepanel;
    static LanGamePanel langamepanel;
    static GameBoardPanel gameboardpanel;

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

    public static void localButtonClicked() {
        if (startpanel.txt_nameField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            Server.getInstance().setPlayerName(startpanel.txt_nameField.getText());
            createSaveGamePanel();
            mainframe.remove(startpanel);
            addPanel(savegamepanel);
        }
    }

    public static void lanButtonClicked() {
        if (startpanel.txt_nameField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            Server.getInstance().setPlayerName(startpanel.txt_nameField.getText());
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
        GameBoardController controller = new GameBoardController();
        gameboardpanel = controller.startGame(Server.getInstance().newBotGame());
        mainframe.remove(savegamepanel);
        addPanel(gameboardpanel);
    }

    public static void repaintFrame() {
        mainframe.setVisible(true);
        mainframe.repaint();
    }

    static void saveButtonActionListener() {
    }

    static void newLanGameButtonActionListener() {
        GameBoardController controller = new GameBoardController();
        gameboardpanel = controller.startGame(Server.getInstance().newGame());
        mainframe.remove(langamepanel);
        addPanel(gameboardpanel);
    }
}
