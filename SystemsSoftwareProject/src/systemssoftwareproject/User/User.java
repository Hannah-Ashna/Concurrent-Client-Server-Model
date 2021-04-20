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
    public List<String> WSids = new LinkedList<>(); 
    public WSSTYPE weatherStationList = new WSSTYPE();
    public String currentWSID = "None";
    private ObjectInputStream inFromStation;
    private PrintWriter outToStation;
    private ObjectOutputStream out;
    private UserClient gui;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("User - Attempting to Login");
        LoginForm loginForm = new LoginForm();
        while (loginForm.returnStatus() == false){
            // Waits for user to finish logging in
            System.out.println("User - Logging in ...");
        }
        if (loginForm.returnStatus()){
            String test_username = loginForm.getUsername();
            User user = new User();
            user.run(test_username);
            System.out.println("User - Login Successful");
        }
        
    }
    
    public void run(String test_username) throws IOException, ClassNotFoundException, InterruptedException {

        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9090);
        
        //var scanner = new Scanner(System.in);
        inFromStation = new ObjectInputStream(socket.getInputStream());
        outToStation = new PrintWriter(socket.getOutputStream(), true);
        out = new ObjectOutputStream(socket.getOutputStream());
        //Test to request stations at the beginning of the program
        //Runs automatic download of latest data from the server.
         DataUpdater dataUpdater = new DataUpdater(this);
         new Thread((Runnable) dataUpdater).start();
         gui = new UserClient(this);
         gui.setVisible(true);
         requestStationIDList();
         sendUsernames(test_username);
         
         while(true){
            try{
                int inputType = inFromStation.readInt();
                System.out.println(inputType);
                if(inputType == 0){
                    //Donloads all weatherStations 
                    //NOT TO BE USED ANYMORE
                    System.out.println("Testing User Client <-> Server Communication:");
                    //updates the list of weaterstations when it recives new data.
                    weatherStationList = (WSSTYPE)inFromStation.readObject();
                    //System.out.println(weatherStationList.wsCount());
                    System.out.println(this.getIds());
                    gui.updateWSList();

                } else if (inputType == usercom.WEATHERSTATION){
                    WeatherStationType weatherStation = (WeatherStationType) inFromStation.readObject();
                    weatherStationList.replaceStation(weatherStation);
                    System.out.println(weatherStation);
                    gui.updateDataDisp();
                }else if(inputType == 2){
                    WSids = (List<String>) inFromStation.readObject(); 
                    System.out.println(WSids);
                    gui.updateWSList();
                }
                    
            }catch(IOException e){
            }
        }
    }
    public void sendUsernames(String test_username) throws InterruptedException, IOException{
       outToStation.println(usercom.USERNAME);
       out.writeObject(test_username);
    }
    
    public void updateSelectedStation(String ID){
        currentWSID = ID;
    }
    public void requestStations() throws InterruptedException{
       outToStation.println(usercom.REQUESTSTATIONS);
    }
     public void requestStation(String ID){
        outToStation.println(usercom.REQUESTSTATION + ID);
    }
    public void requestStationIDList(){
        outToStation.println(usercom.REQUESTSTATIONLIST);
        outToStation.flush();
    }
    public void closeProgram(){
        outToStation.println("CLOSE");
    }
    
    public List<String> getIds(){
        return WSids;
    }
    
    
 
}
