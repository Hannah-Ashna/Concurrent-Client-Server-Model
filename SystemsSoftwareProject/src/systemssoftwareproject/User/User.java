package systemssoftwareproject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import systemssoftwareproject.DataStructures.WSSTYPE;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.usercom;
import systemssoftwareproject.GUI.LoginForm;
import systemssoftwareproject.GUI.UserClient;
import systemssoftwareproject.WeatherStation.WeatherStation;

public class User {
    public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
    private ObjectInputStream inFromStation;
    private PrintWriter outToStation;
    private UserClient gui;
    public boolean running = true;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("User - Attempting to Login");
        LoginForm loginForm = new LoginForm();
        while (loginForm.returnStatus() == false){
            // Waits for user to finish logging in
            System.out.println("User - Logging in ...");
        }
        if (loginForm.returnStatus()){
            User user = new User();
            user.run();
            System.out.println("User - Login Successful");
        }
        
    }
    
    public void run() throws IOException, ClassNotFoundException, InterruptedException {

        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9090);
        
        //var scanner = new Scanner(System.in);
        inFromStation = new ObjectInputStream(socket.getInputStream());
        outToStation = new PrintWriter(socket.getOutputStream(), true);
        //Test to request stations at the beginning of the program
        //Runs automatic download of latest data from the server.
         DataUpdater dataUpdater = new DataUpdater(this);
         new Thread((Runnable) dataUpdater).start();
         gui = new UserClient(this);
         gui.setVisible(true);
         requestStations();
        while(running){
            try{
                if(inFromStation.readInt() == 0){
                    System.out.println("Testing User Client <-> Server Communication:");
                    //updates the list of weaterstations when it recives new data.
                    weatherStations.removeAll(weatherStations);
                    try{
                        while(true){
                    weatherStations.add((WeatherStationType) inFromStation.readObject());
                    System.out.println(weatherStations.toString());
                        }
                    }catch(IOException e){
                        System.out.println("dwn complete");
                    gui.updateWSList();
            }
                }
            }catch(IOException e){
            }
        }
    }
    public void requestStations() throws InterruptedException{
       outToStation.println(usercom.REQUESTSTATIONS);
    }
    public void closeProgram(){
        outToStation.println("CLOSE");
        running = false;
    }
    
    public List<String> getIds(){
        List<String> weatherStationIDs;
        weatherStationIDs = new LinkedList<>();
        try{
        weatherStations.forEach((WeatherStationType _item) -> {
            weatherStationIDs.add(_item.getID());
        });
        } catch(Exception e){
            List<String> weatherStationfail = new LinkedList<>();
            weatherStationfail.add("Refresh GUI");
            return  weatherStationfail;
        }
        return weatherStationIDs;
    }
    public WeatherStationType getByID(String ID){
        for (WeatherStationType weatherStation : weatherStations) {
         if(weatherStation.getID().equals(ID)){
             return weatherStation;
         }   
        }
        return null;
    }
    
    
 
}
