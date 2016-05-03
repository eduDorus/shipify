/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.network;

import java.io.Serializable;

/**
 *
 * @author Dorus Janssens
 */
public class TestObject implements Serializable {

    int value;
    String id;

    public TestObject(int v, String s) {
        this.value = v;
        this.id = s;
    }
    
    @Override
    public String toString() {
        return id;
    }
}
