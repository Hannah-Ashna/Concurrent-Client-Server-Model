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
    private final int waitTime = 1;
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
        try {    
            while(true){
               server.weatherStations.add(weatherStation);
                // Create IO Streams
                            //System.out.println("testing");
                ObjectInputStream inFromStation = new ObjectInputStream(clientSocket.getInputStream());
                var outToStation = new PrintWriter(clientSocket.getOutputStream(), true);
                //Will Request then print the Stations ID
                //Will then request a sample every 20 seconds forever unless the client disconnects!
                 while (true) {
                         outToStation.println(wscom.SEND);
                        int type  = inFromStation.readInt();
                        if(type == 0){
                        SampleType sample = (SampleType)inFromStation.readObject();
                        weatherStation.addSample(sample);
                        //These are commented out as they are for testing!
                        //System.out.println(weatherStation.sampleCount());
                        //System.out.println(sample.getHumid());
                        outToStation.println(wscom.SAMPLECONFIRM);
                        //System.out.println("Waiting 20 seconds to continue");
                        TimeUnit.SECONDS.sleep(waitTime);// replace with constant
                        }else{
//
                        }
                }
                

            }
            
        } 

        catch (IOException e) { 
             System.out.println("WeatherStation has disconnected.");
             server.weatherStations.remove(weatherStation);
        } catch (ClassNotFoundException | InterruptedException ex) {
            Logger.getLogger(WsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
} 
