package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.mediator.Server;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        if (startpanel.txt_nameField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            playername = startpanel.txt_nameField.getText();
            createSaveGamePanel();
            mainframe.remove(startpanel);
            addPanel(savegamepanel);
        }
    }

    public static void lanButtonClicked() {
        if (startpanel.txt_nameField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie ihren Namen an.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        } else {
            playername = startpanel.txt_nameField.getText();
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
        Server.getInstance().newBotGame(playername);
        createGameBoardPanel();
        mainframe.remove(savegamepanel);
        addPanel(gameboardpanel);
    }

    public static void repaintFrame() {
        mainframe.setVisible(true);
        mainframe.repaint();
    }

    static void playerFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> playerFields) {
    }

    static void opponentFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> opponentFields) {
        Gamestate gamestate = Server.getInstance().shoot(fieldButton.getXCords(), fieldButton.getYCords());

        Field[][] field = gamestate.getOpponentPlayer().getField();
        opponentFields.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
            _item.updateIcon();
        });
    }

    static void saveButtonActionListener() {
    }

    static void newLanGameButtonActionListener() {
        Server.getInstance().newGame(playername);
        createGameBoardPanel();
        mainframe.remove(savegamepanel);
        addPanel(gameboardpanel);
    }
}
