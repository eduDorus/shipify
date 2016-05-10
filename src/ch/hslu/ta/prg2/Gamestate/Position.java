/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.Gamestate;

/**
 *
 * 
 */
public class Position {
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }    
}
