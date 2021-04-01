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
       boolean ID_found = false;
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
                         if (ID_found == false){
                             outToStation.println(wscom.SENDID);
                         }
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
                        }
                        else if (type ==  1){
                            boolean ID_exists = false;
                             boolean append_file = false;
                            
                            File myObj = new File("WeatherStationID list.txt");
                            if (myObj.createNewFile()) {
                                System.out.println("File created: " + myObj.getName());
                                append_file = false; //if it doesn't then writing to the file shouldn't be append mode
                            } else {
                                 System.out.println("File already exists");
                                 append_file = true; 
                                  //if it does then writing to the file should be append mode
                            }
                            
                            while (ID_found == false){
                                String weatherstationID = (String)inFromStation.readObject();

                                FileReader fin = new FileReader("WeatherStationID list.txt"); // read from the file
                                BufferedReader din = new BufferedReader(fin);


                                String line = null; // line of text

                                while ((line = din.readLine()) != null) {

                                    if (line.equals( weatherstationID )){ // checks if ID already exists in the file
                                        ID_exists = true; 
                                        System.out.println("ID already exists");
                                        break;   
                                    }
                                }

                                if (ID_exists == false){ // if the file does not exist
                                    // what this should do is then add the ID to the file 
                                    FileWriter fout = new FileWriter("WeatherStationID list.txt",append_file); //append_file is just saying if the file should be append mode or not
                                    PrintWriter pout = new PrintWriter(fout,true);
                                    pout.println(weatherstationID); 
                                    //toWeatherStation.writeUTF("ID has been added");
                                    outToStation.println(wscom.IDCONFIRMED);
                                    System.out.println("Inform WS Client -> ID has been added");
                                    ID_found = true;
                                    break;

                                }
                                else{
                                    // if the id already exists then do this
                                     //toWeatherStation.writeUTF("ID already exists");
                                     outToStation.println(wscom.SENDID);
                                     System.out.println("Inform WS Client -> ID already exists");

                                }



                            }

                        }
                        else{
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
