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
    private int x;
    private int y;
    private Field[][] field = Server.getInstance().getGamestate().getOpponent(Server.getInstance().getGamestate().getPlayer("bot").getName()).getField();

    public KI(Gamestate state) {

        this.state = state;
        
        readLastShootFromFile();
        
        if (x == 0 && y == 0) {
            writeLastShootInFile();
            randomShoot();
        }
        
        if(field[x][y] == Field.WATER){
            
            randomShoot();
            
        }
        
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

        int whichField = randomInt.nextInt(8);

        switch (whichField) {

            case 0:
                this.x = x-1;
                this.y = y;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 1:
                this.x = x-1;
                this.y = y-1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 2:
                this.x = x-1;
                this.y = y+1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 3:
                this.x = x+1;
                this.y = y;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 4:
                this.x = x+1;
                this.y = y-1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 5:
                this.x = x+1;
                this.y = y+1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 6:
                this.x = x;
                this.y = y-1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
                break;
            case 7:
                this.x = x;
                this.y = y+1;
                writeLastShootInFile();
                Server.getInstance().shoot(x, y);
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
            fw = new FileWriter("lastBotShoot.txt");
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
            fr = new FileReader("lastBotShoot.txt");
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
