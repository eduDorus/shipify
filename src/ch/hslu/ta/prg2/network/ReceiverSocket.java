package ch.hslu.ta.prg2.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5001);
        while (true) {
            try {
                Socket receiverSocket = server.accept();
                ReceiverHandler rHandler = new ReceiverHandler(receiverSocket);
                new Thread(rHandler).start();
            } catch (Exception e) {
                System.err.println(
                        "Error: " + e.getMessage());
                server.close();
            }
        }
    }
}
