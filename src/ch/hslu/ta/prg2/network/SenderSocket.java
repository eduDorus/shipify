package ch.hslu.ta.prg2.network;

import java.net.Socket;

public class SenderSocket {

    public static void sendGame(String hostname, int senderPort, TestObject object) {
        try {
            Socket senderSocket = new Socket(hostname, senderPort);
            SenderHandler sHandler = new SenderHandler(senderSocket, object);
            new Thread(sHandler).start();

        } catch (Exception e) {
            System.err.println(
                    "Error: " + e.getMessage());

        }
    }
}
