package systemssoftwareproject.Serveroop;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import systemssoftwareproject.DataStructures.WeatherStationType;

public class wsConnection implements Runnable {
    private Server server;
    // Constructor 
    public wsConnection(Server server){ 
        this.server = server;
    } 
    @Override
    public void run() {
        while(true){
            try {
                Socket wsclient = server.ws.accept();

                // Displaying that new client is connected to server
                System.out.println("New WS connected: "
                        + wsclient.getInetAddress()
                                .getHostAddress());

                // Create a new thread object
                WsHandler wsSock
                        = new WsHandler(wsclient, server);

                // This thread will handle the client separately
                new Thread((Runnable) wsSock).start();

            } catch (IOException ex) {
                Logger.getLogger(wsConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
