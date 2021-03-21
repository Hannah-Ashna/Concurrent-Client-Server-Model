package systemssoftwareproject.ServerNicksVersion;
import java.io.*; 
import java.net.*; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import systemssoftwareproject.WeatherStation.WeatherStation;
//import 
        
public class Server implements OnNewUserCreatedEventListner{
   public List<WeatherStation> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
   public static void main(String[] args) 
    { 
        Server server = new Server();
        server.start();
    }

    @Override
    public void OnNewUserCreatedEvent() {
        System.out.println("The user has been created!");
    }
    public void start(){
                ServerSocket server = null; 
  
        try { 
  
            // server is listening on port 1234 
            server = new ServerSocket(1234); 
            server.setReuseAddress(true); 
  
            // running infinite loop for getting 
            // client request 
            while (true) { 
  
                // socket object to receive incoming client 
                // requests 
                Socket client = server.accept(); 
  
                // Displaying that new client is connected 
                // to server 
                System.out.println("New client connected "
                                   + client.getInetAddress() 
                                         .getHostAddress()); 
  
                // create a new thread object 
                ClientHandler clientSock 
                    = new ClientHandler(client, this); 
  
                // This thread will handle the client 
                // separately 
                new Thread((Runnable) clientSock).start(); 
            } 
        } 
        catch (IOException e) { 
        } 
        finally { 
            if (server != null) { 
                try { 
                    server.close(); 
                } 
                catch (IOException e) { 
                } 
            } 
        }
    }
}
