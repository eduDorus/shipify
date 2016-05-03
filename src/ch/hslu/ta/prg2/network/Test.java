package ch.hslu.ta.prg2.network;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        SenderSocket.sendGame("localhost", 5001, new TestObject(12, "Game World!"));
        SenderSocket.sendGame("localhost", 5001, new TestObject(12, "neues Object World!"));
        SenderSocket.sendGame("localhost", 5001, new TestObject(12, "Letztes"));
    }
}
