package systemssoftwareproject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
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
    public WSSTYPE weatherStationList;
    private ObjectInputStream inFromStation;
    private PrintWriter outToStation;
    private UserClient gui;
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
        while(true){
            try{
                if(inFromStation.readInt() == 0){
                    System.out.println("Testing User Client <-> Server Communication:");
                    //updates the list of weaterstations when it recives new data.
                    weatherStationList = (WSSTYPE)inFromStation.readObject();
                    //System.out.println(weatherStationList.wsCount());
                    System.out.println(this.getIds());
                    gui.updateWSList(this);
                    gui.getWSList(weatherStationList);

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
    }
    
    public List<String> getIds(){
        List<String> weatherStationIDs;
        weatherStationIDs = new LinkedList<>();
        try{
        weatherStationList.weatherStations.forEach((WeatherStationType _item) -> {
            weatherStationIDs.add(_item.getID());
        });
        } catch(Exception e){
            List<String> weatherStationfail = new LinkedList<>();
            weatherStationfail.add("Refresh GUI");
            return  weatherStationfail;
        }
        return weatherStationIDs;
    }
    
    
 
}
