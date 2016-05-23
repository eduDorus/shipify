package ch.hslu.ta.prg2.network;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ReceiverHandler implements Runnable {

    private final Socket client;

    public ReceiverHandler(Socket c) {
        client = c;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

            Gamestate game = ((Gamestate) ois.readObject());

            System.out.println(game.toString());

            ois.close();
            client.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SenderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
