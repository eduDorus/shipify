package ch.hslu.ta.prg2.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

class SenderHandler implements Runnable {

    private final Socket client;
    private final TestObject object;

    public SenderHandler(Socket c, TestObject o) {
        client = c;
        object = o;
    }

    @Override
    public void run() {
        try (ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {
            oos.writeObject(object);
            oos.close();
            client.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
