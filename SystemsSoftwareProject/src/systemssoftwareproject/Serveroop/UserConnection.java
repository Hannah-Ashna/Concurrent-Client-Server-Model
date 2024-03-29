package systemssoftwareproject.Serveroop;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import systemssoftwareproject.DataStructures.WeatherStationType;


public class UserConnection implements Runnable {
    private Server server;
    
    // Constructor 
    public UserConnection(Server server){ 
        this.server = server;
    } 
    
    @Override
    public void run() {
        while(true){
            try {
                Socket userclient = server.user.accept();

                // Displaying that new client is connected to server
                System.out.println("New user connected: "
                        + userclient.getInetAddress()
                                .getHostAddress());

                // Create a new thread object
                UserHandler userSock = new UserHandler(userclient, server);

                // This thread will handle the client separately
                new Thread((Runnable) userSock).start();

            } catch (IOException ex) {
                Logger.getLogger(UserConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
