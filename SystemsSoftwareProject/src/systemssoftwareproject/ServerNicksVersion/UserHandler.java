package systemssoftwareproject.ServerNicksVersion;
import java.net.Socket;
import java.io.*; 
import java.util.Scanner;


public class UserHandler implements Runnable { 
    private final Socket clientSocket; 
    //private User user;
    private boolean authenticationstatus = false;
    private Server server;
    // Constructor 
    public UserHandler(Socket socket, Server server){ 
        this.clientSocket = socket; 
        //this.weatherStation = new WeatherStation();
        this.server = server;
    } 

    @Override
    public void run(){ 
        try {    
            while(true){
                var inFromClient = new Scanner(clientSocket.getInputStream());
                var outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
                //Request authentication package
                //If the authentication has not been confirmed do not do anything else
                // once authenitcaion is okay start responding to commands
                
                
                //while loop (while authentication has not been approved)
                    //if the command is authenticate followed by valid data
                    //Check details change autentication status if connect
                //While loop while autentication is approved
                    //switch command comming is x
                        //Package is sent back with requested data
                        
                
            }
            
        } 

        catch (IOException e) { 
             System.out.println("ahhh");
        }
    } 
} 
