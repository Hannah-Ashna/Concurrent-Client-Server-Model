/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Serveroop;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import systemssoftwareproject.DataStructures.WeatherStationType;

/**
 *
 * @author Nicholas McCaig
 */
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
            
            // Displaying that new client is connected
            // to server
            System.out.println("New ws connected "
                    + wsclient.getInetAddress()
                            .getHostAddress());
            
            // create a new thread object
            WsHandler wsSock
                    = new WsHandler(wsclient, server);
            
            // This thread will handle the client
            // separately
            new Thread((Runnable) wsSock).start();
            
        } catch (IOException ex) {
            Logger.getLogger(wsConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    //}
    }
    
}
