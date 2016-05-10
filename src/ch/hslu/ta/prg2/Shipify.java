/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2;

import ch.hslu.ta.prg2.gui.StartPanelController;
import ch.hslu.ta.prg2.gui.SuperController;

/**
 *
 * @author julian
 */
public class Shipify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //GUI SUPER CONTROLLER
        //=================
        SuperController superController = new SuperController();

        createControllers();

    }

    private static void createControllers() {
        StartPanelController startPanelController1 = new StartPanelController();
    }

}
