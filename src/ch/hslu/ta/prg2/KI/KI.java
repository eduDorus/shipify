/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.KI;

import ch.hslu.ta.prg2.Gamestate.*;
import ch.hslu.ta.prg2.mediator.*;
import java.util.Random;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KI {

    private Gamestate state;
    private int x = 0;
    private int y = 0;
    private Field[][] field = Server.getInstance().getGamestate().getOpponent(Server.getInstance().getGamestate().getPlayer("bot").getName()).getField();

    public KI(Gamestate state) {

        this.state = state;
        
        
        if (x == 0 && y == 0) {
            writeLastShootInFile();
            randomShoot();
        }
        
        readLastShootFromFile();

        if (field[x][y] == Field.HIT) {

            randomShoot();

        }

        if (field[x][y] == Field.SHIPHIT) {

            shootAround(x, y);

        }

        if (field[x][y] == Field.SHIPDESTROYED) {

            randomShoot();

        }

    }

    public Gamestate randomShoot() {

        Random randomInt = new Random();

        
        this.x = randomInt.nextInt(10);
        this.y = randomInt.nextInt(10);

        if(this.field[x][y] == Field.GAP || this.field[x][y] == Field.HIT || this.field[x][y] == Field.SHIPDESTROYED){
            randomShoot();
        }
        
        Server.getInstance().shoot(x, y);
        
        writeLastShootInFile();

        return state;

    }

    public Gamestate shootAround(int x, int y) {

        Random randomInt = new Random();

        int whichField = randomInt.nextInt(9);

        switch (whichField) {

            case 0:
                Server.getInstance().shoot(x - 1, y);
                break;
            case 1:
                Server.getInstance().shoot(x - 1, y - 1);
                break;
            case 2:
                Server.getInstance().shoot(x - 1, y + 1);
                break;
            case 3:
                Server.getInstance().shoot(x + 1, y);
                break;
            case 4:
                Server.getInstance().shoot(x + 1, y - 1);
                break;
            case 5:
                Server.getInstance().shoot(x + 1, y + 1);
                break;
            case 6:
                Server.getInstance().shoot(x, y);
                break;
            case 7:
                Server.getInstance().shoot(x, y - 1);
                break;
            case 8:
                Server.getInstance().shoot(x, y + 1);
                break;

        }

        return state;
    }

    //ONLY USED for DemoKI
    public int getX() {
        return x;
    }

    //ONLY USED for DemoKI
    public int getY() {
        return y;
    }

    private void writeLastShootInFile(){
    
        FileWriter fw = null;
        try {
            fw = new FileWriter("test.txt");
            BufferedWriter out = new BufferedWriter(fw);
            out.write(x+"");
            out.newLine();
            out.write(y+"");
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    private void readLastShootFromFile(){
        
        FileReader fr = null;
        try {
            fr = new FileReader("test.txt");
            BufferedReader in = new BufferedReader(fr);
            String x = null;
            try {
                x = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
            }
            String y = null;
            try {
                y = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
            }
            //REMOVE LATER
            System.out.println("X: "+x);
            System.out.println("Y: "+y);
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(KI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
