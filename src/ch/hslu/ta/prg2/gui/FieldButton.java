package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.awt.Color;
import javax.swing.JButton;

public class FieldButton extends JButton {

    private final int x;
    private final int y;
    private Field fieldstate;

    public FieldButton(int x, int y, Field fieldState) {
        this.x = x;
        this.y = y;
        setFieldstate(fieldState);
    }

    private void updateIcon() {
        if (this.fieldstate == Field.WATER) {
            this.setBackground(Color.blue);
        }
        if (this.fieldstate == Field.HIT) {
            this.setBackground(Color.red);
        }
        if (this.fieldstate == Field.SHIPHIT) {
            this.setText("X");
            this.setBackground(Color.red);
        }
        if (this.fieldstate == Field.SHIPDESTROYED) {
            this.setText("X");
            this.setBackground(Color.BLACK);
        }
        if (this.fieldstate == Field.SHIP) {
            this.setBackground(Color.DARK_GRAY);
        }
    }

    public Position getPosition() {
        return new Position(x, y);
    }

    public Field getFieldstate() {
        return fieldstate;
    }

    public void setFieldstate(Field fieldstate) {
        this.fieldstate = fieldstate;
        updateIcon();
    }

    public void setTempFieldColor(Color c) {
        this.setBackground(c);
    }

    public void resetTempFieldColor() {
        updateIcon();
    }
}