package systemssoftwareproject.Serveroop;
import java.net.Socket;
import java.io.*; 
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ObjectInputStream inFromUser;
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
            in =  new Scanner(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            //inFromUser = new ObjectInputStream(clientSocket.getInputStream());
            while(true){
                while (in.hasNextLine()) {
                    ReceiveRequest();
                }
            }
        } catch (IOException ex) {
            System.out.println("User Disconnected");
            server.users.remove(userType);
        }   catch (ClassNotFoundException ex) {    
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }
        
        
     
    private void ReceiveRequest() throws IOException, ClassNotFoundException{
        String line = in.nextLine();
        System.out.println(line);
        if(line.startsWith(usercom.REQUESTSTATIONS)){
            out.writeInt(usercom.WSSTYPE);
            WSSTYPE wss = new WSSTYPE();
            wss.weatherStations = server.weatherStations;
            out.writeObject(wss);
            out.flush();
            out.reset();
        }else if(line.startsWith(usercom.REQUESTSTATION)){
            String wsID = line.substring(usercom.REQUESTSTATION.length()); //Removes command to get the ID
            System.out.println(wsID);
            WeatherStationType ws = server.getWSByID(wsID);
            out.writeInt(usercom.WEATHERSTATION);
            out.writeObject(ws);
            out.flush();
            out.reset();
        }else if(line.startsWith(usercom.REQUESTSTATIONLIST)){
            List<String> ids =  new LinkedList<>();
            server.weatherStations.forEach(weatherStation -> {
                ids.add(weatherStation.getID());
            });
            System.out.println(ids + "list");
            out.flush();
            out.writeInt(2);
            out.writeObject(ids);
            out.flush();
            out.reset();
        }else if(line.startsWith(usercom.CLOSE)){
            System.out.println("User Disconnected");
            server.users.remove(userType);
            running = false;
        }else if(line.startsWith(usercom.USERNAME)){
            System.out.println("Server recieving username");
            String Username = line.substring(usercom.USERNAME.length()); //Removes command to get the ID
            System.out.println("Username" + Username);
            server.users.add(userType);
            userType.setUsername(Username);
        }
    }
} 
