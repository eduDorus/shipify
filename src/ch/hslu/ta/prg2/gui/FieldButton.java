package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import java.awt.Color;
import javax.swing.JButton;

public class FieldButton extends JButton {

    
    private int x;
    private int y;
    public FieldButton(int x, int y, Field fieldState) {
        super();
        this.x = x;
        this.y = y;
        //this.setVisible(true);
        this.setBackground(Color.WHITE);
    }

    public int getXCords() {
        return x;
    }

    public int getYCords() {
        return y;
    }    
}
