package ch.hslu.ta.prg2.view;

import javax.swing.*;


/**
 *
 */


public class startpanel extends JPanel {
    
    //COMPONENTS
    JButton btn_start;
    
    
    
//    public startpanel(){
//    
//        this(mainframe.WIDTH,mainframe.HEIGHT);
//    }
//    
    
    public startpanel(int WINDOW_HEIGHT,int WINDOW_LENGTH){
        
        this.setSize(WINDOW_HEIGHT, WINDOW_LENGTH);
        
        createComponents();
        
        
        this.add(btn_start);
    }
    
    private void createComponents(){
        
        btn_start = new JButton();
        btn_start.setText("HALLO MAMI");
        btn_start.setBounds(400, 400, 1000, 1000);
        
    }
}