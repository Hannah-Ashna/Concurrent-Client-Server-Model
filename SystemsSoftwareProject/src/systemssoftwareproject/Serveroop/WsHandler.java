package systemssoftwareproject.Serveroop;
import java.net.Socket;
import java.io.*; 
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.wscom;
import systemssoftwareproject.WeatherStation.WeatherStation;


public class WsHandler implements Runnable {
    private final int waitTime = 30;
    private final Socket clientSocket; 
    private WeatherStationType weatherStation;
    private Server server;
   
    // Constructor 
    public WsHandler(Socket socket, Server server){ 
        this.clientSocket = socket; 
        this.weatherStation = new WeatherStationType();
        this.server = server;
    } 

    @Override
    public void run(){ 
        boolean ID_found = false;
        try {    
            server.weatherStations.add(weatherStation);
            // Create IO Streams
            // System.out.println("testing");
            ObjectInputStream inFromStation = new ObjectInputStream(clientSocket.getInputStream());
            PrintWriter outToStation = new PrintWriter(clientSocket.getOutputStream(), true);
            // Will Request then print the Stations ID
            // Will then request a sample every 20 seconds forever unless the client disconnects!

            while (true) {
                if (ID_found == false){
                    outToStation.println(wscom.SENDID);
                }
                
                outToStation.println(wscom.SEND);
                int type  = inFromStation.readInt();
                
                if(type == 0){
                    SampleType sample = (SampleType)inFromStation.readObject();
                    weatherStation.addSample(sample);
                    // These are commented out as they are for testing!
                    // System.out.println(weatherStation.sampleCount());
                    // System.out.println(sample.getHumid());
                    outToStation.println(wscom.SAMPLECONFIRM);
                    //S ystem.out.println("Waiting 20 seconds to continue");
                    //TimeUnit.SECONDS.sleep(waitTime);// replace with constant
                }
                
                else if (type ==  1){
          
                    String weatherstationID = (String)inFromStation.readObject();// gets data object from the weatherstation and store it (The ID)

                    boolean ID_unique = server.IDUnique(weatherstationID); //Runs the IDunique function in the serverfunctions.java file

                    if (ID_unique == true){ // if the ID does not exist
                        ID_found = true; // stop telling the weatherstation to send an ID
                        outToStation.println(wscom.IDCONFIRMED); // Tell weatherstation ID confirmed
                        System.out.println("Inform WS Client -> ID has been added");
                                     

                 //sets ID of weatherstation in the linked list
                        weatherStation.setID(weatherstationID);
                        try {
                            server.gui.updateGUI();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(WsHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                        //toWeatherStation.writeUTF("ID has been added");
                     
                     

                    }
                    else{
                        // if the id already exists then do this
                         //toWeatherStation.writeUTF("ID already exists");
                        System.out.println("Inform WS Client -> ID already exists");
                    }
                }
            }
        } catch (IOException e) { 
            System.out.println("WeatherStation has disconnected.");
            server.weatherStations.remove(weatherStation);
        } catch (ClassNotFoundException ex) {
        } 
    }   
} 
