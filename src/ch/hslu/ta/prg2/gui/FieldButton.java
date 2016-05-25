package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import java.awt.Color;
import javax.swing.JButton;

public class FieldButton extends JButton {

    private int x;
    private int y;
    private Field fieldstate;

    public FieldButton(int x, int y, Field fieldState) {
        this.x = x;
        this.y = y;
        setFieldstate(fieldState);
    }

    private void updateIcon() {
        if (this.fieldstate == Field.WATER) {
            //this.setIcon(new ImageIcon(getClass().getResource("water.jpg")));
            this.setBackground(Color.blue);
        }
        if (this.fieldstate == Field.HIT) {
            //this.setIcon(new ImageIcon(getClass().getResource("hit.png")));
            this.setBackground(Color.red);
        }
        if (this.fieldstate == Field.SHIP) {
            this.setBackground(Color.DARK_GRAY);
        }
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
        updateIcon();
    }
    
    public void setTempFieldColor(Color c){
        this.setBackground(c);
    }
    
    public void resetTempFieldColor(){
        updateIcon();
    }

}
