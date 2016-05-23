package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FieldButton extends JButton {

    
    private int x;
    private int y;
    private Field fieldstate;
    
    public FieldButton(int x, int y, Field fieldState) {
        
        this.x = x;
        this.y = y;
        this.fieldstate = fieldState;
       
        this.setBackground(Color.WHITE);
        
        updateIcon();
    }
    
    private void updateIcon(){
         if(this.fieldstate == Field.WATER){
            this.setIcon(new ImageIcon(getClass().getResource("water.jpg")));
              
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
    }
    
    
}