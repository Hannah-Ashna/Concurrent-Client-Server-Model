package systemssoftwareproject.Server;
import java.io.*; 
import java.net.*; 
import java.util.ArrayList;
import java.util.List;
        
public class Main implements OnNewUserCreatedEventListner{
   //private List<WeatherStation> weatherStations =  new ArrayList<>(); 
    
   static boolean which_client = false;
   
   public static void connection_from_user(){
       which_client = false;
   }
   
   public static void connection_from_weather_station(){
       which_client = true;
   }
   
   public static void main(String[] args) 
    { 
        ServerSocket server = null; 
        try { 
  
            // Server is listening on port 1234 
            server = new ServerSocket(1234); 
            server.setReuseAddress(true); 
  
            // Running infinite loop for getting client request 
            while (true) { 
                Socket socket = server.accept();
                
                // If Client is a Weather Station
                if (String.valueOf(socket.getLocalSocketAddress()).equals("/127.0.0.2:1234")){
                    Socket WeatherStation = socket;
                    // Displaying that a new weather station client is connected to server 
                    System.out.println("Host Address - Aka SERVER: " + WeatherStation.getInetAddress().getHostAddress() 
                                        + "\nLocal Socket Address: " + WeatherStation.getLocalSocketAddress()); 

                    // Create a new thread object 
                    WeatherStationHandler weatherStationSocket
                        = new WeatherStationHandler(WeatherStation); 

                    // This thread will handle the client separately 
                    new Thread((Runnable) weatherStationSocket).start();
                
                }
                
                // If Client is a User
                else if (String.valueOf(socket.getLocalSocketAddress()).equals("/127.0.0.3:1234")){
                    Socket UserClient = socket; 

                    // Displaying that a new user client is connected to server 
                    System.out.println("Host Address - Aka SERVER: " + UserClient.getInetAddress().getHostAddress() 
                                        + "\nLocal Socket Address: " + UserClient.getLocalSocketAddress()); 

                    // Create a new thread object 
                    ClientHandler clientSock = new ClientHandler(UserClient); 

                    // This thread will handle the client separately 
                    new Thread((Runnable) clientSock).start();
                }
            }
        } catch (IOException e){ 
        } 
        finally { 
            if (server != null) { 
                try { 
                    server.close(); 
                } catch (IOException e) { 
                } 
            } 
        } 
    }

    

    @Override
    public void OnNewUserCreatedEvent() {
        System.out.println("The user has been created!");
    }
}
