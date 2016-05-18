package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;

public class FieldButton extends JButton {

    
    private int x;
    private int y;
    private Field fieldstate;
    
    public FieldButton(int x, int y, Field fieldState, Icon icon) {
        super(icon);
        this.x = x;
        this.y = y;
        this.fieldstate = fieldState;
        //this.setVisible(true);
        this.setBackground(Color.WHITE);
    }

    public int getXCords() {
        return x;
    }

    public int getYCords() {
        return y;
    }    

    public Field getFieldstate() {
        return fieldstate;
    }

    public void setFieldstate(Field fieldstate) {
        this.fieldstate = fieldstate;
    }
    
    
}
