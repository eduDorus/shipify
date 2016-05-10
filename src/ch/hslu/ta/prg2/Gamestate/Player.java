/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Player {
    
    private String name;
    
    private ArrayList<Ship> ships;
    private ArrayList<Shoot> shoots;

    public Player(String name) {
        this.name = name;
        
        this.ships = new ArrayList<>();
        this.shoots = new ArrayList<>();
        
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Shoot> getShoots() {
        return shoots;
    }
    
    public Field[][] getField(){
        Field[][] fields = new Field[10][10];
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
               //Implement logic here
                fields[x][y] = Field.WATER;
            }
        }
        return fields;
    }
}
