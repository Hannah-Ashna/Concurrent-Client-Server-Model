package systemssoftwareproject.Serveroop;
import java.net.Socket;
import java.io.*; 
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WSSTYPE;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.usercom;
import systemssoftwareproject.DataStructures.wscom;


public class UserHandler implements Runnable {
    private final Socket clientSocket; 
    private UserType userType;
    private Server server;
    private Scanner in;
    private ObjectOutputStream  out;
    private boolean running = true;
    
    // Constructor 
    public UserHandler(Socket socket, Server server){ 
        this.clientSocket = socket; 
        this.userType = new UserType();
        this.server = server;
    } 

    
    @Override
    public void run() {
        while(running){
        try {
            server.users.add(userType);
            userType.setUsername("test");
            in =  new Scanner(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            while(true){
                while (in.hasNextLine()) {
                    ReceiveRequest();
                }
            }
        } catch (IOException ex) {
            System.out.println("User Disconnected");
            server.users.remove(userType);
        }    
        }
    }
        
        
     
    private void ReceiveRequest() throws IOException{
        String line = in.nextLine();
        System.out.println(line);
        if(line.startsWith(usercom.REQUESTSTATIONS)){
            out.writeInt(usercom.WSSTYPE);
            WSSTYPE wss = new WSSTYPE();
            wss.weatherStations = server.weatherStations;
            out.writeObject(wss);
        } else if(line.startsWith("CLOSE")){
            System.out.println("User Disconnected");
            server.users.remove(userType);
            running = false;
        }
    }
} 
