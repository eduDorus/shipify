package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
    
    private JPanel playerfield = new JPanel();
    private JPanel oponentField = new JPanel();
    
    public GameBoardPanel() {
        
        this.setSize(1227, 800);
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.blue);
        
        playerfield.setLayout(new GridLayout(10, 10));
        oponentField.setLayout(new GridLayout(10, 10));
        
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton b = new FieldButton(x, y, Field.WATER);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(b.getX() + ", " + b.getY());
                    }
                });
                
                playerfield.add(b);
                oponentField.add(new FieldButton(x, y, Field.WATER));
            }
        }
        
        this.add(playerfield);
        this.add(oponentField);
    }
}
