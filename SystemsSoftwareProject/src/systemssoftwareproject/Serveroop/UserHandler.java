package systemssoftwareproject.Serveroop;
import java.net.Socket;
import java.io.*; 
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.wscom;


public class UserHandler implements Runnable {
    private final Socket clientSocket; 
    private UserType userType;
    private Server server;
    private Scanner in;
    private ObjectOutputStream  out;
    // Constructor 
    public UserHandler(Socket socket, Server server){ 
        this.clientSocket = socket; 
        this.userType = new UserType();
        this.server = server;
    } 

    @Override
    public void run(){ 
        try {   
            server.users.add(userType);
            in =  new Scanner(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            while(true){
               RecieveRequest();
            }
            
        } 
        catch (IOException e) { 
             System.out.println("User has disconnected.");
             server.users.remove(userType);
        } 
        
    } 
    private void RecieveRequest() throws IOException{
        String line = in.nextLine();
    }
} 
