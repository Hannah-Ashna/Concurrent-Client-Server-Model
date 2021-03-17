package systemssoftwareproject.Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WeatherStationHandler implements Runnable { 
    private final Socket weatherStationSocket; 
  
    // Constructor 
    public WeatherStationHandler(Socket socket){ 
        this.weatherStationSocket= socket; 
    } 

    @Override
    public void run(){ 
     boolean ID_exists = false;
     boolean append_file = false;
                    
        try { 
            //check if the file exists
            File myObj = new File("WeatherStationID list.txt");
             if (myObj.createNewFile()) {
                 System.out.println("File created: " + myObj.getName());
                 append_file = false; //if it doesn't then writing to the file shouldn't be append mode
             } else {
                 System.out.println("File already exists.");
                 append_file = true; 
                  //if it does then writing to the file should be append mode
             }
            while(true){
                // Create IO Streams
                DataInputStream fromWeatherStation = new DataInputStream(weatherStationSocket.getInputStream());
                DataOutputStream toWeatherStation = new DataOutputStream(weatherStationSocket.getOutputStream());   
                
                try {
                     String WeatherStationID = fromWeatherStation.readUTF(); // get ID from weather station
                     
                     FileReader fin = new FileReader("WeatherStationID list.txt"); // read from the file
                     BufferedReader din = new BufferedReader(fin);
                
                
                    
                     
                     String line = null; // line of text
                   
                   
                    

                    while ((line = din.readLine()) != null) {
               
                        if (line.equals(WeatherStationID)){ // checks if ID already exists in the file
                            ID_exists = true; 
                            System.out.println("ID already exists");
                            break;
                           
                        }
                    }
                    if (ID_exists == false){ // if the file does not exist
                        // what this should do is then add the ID to the file 
                        FileWriter fout = new FileWriter("WeatherStationID list.txt",append_file); //append_file is just saying if the file should be append mode or not
                        PrintWriter pout = new PrintWriter(fout,true);
                        pout.println(WeatherStationID); 
                        toWeatherStation.writeUTF("ID has been added");
                        break;
                        
                    }
                    else{
                        // if the id already exists then do this
                         toWeatherStation.writeUTF("ID already exists");
                         System.out.println("response to weatherstation is ID already exists");
                         
                    }
                   
                    
                }                    
                
                
                catch (IOException e){
                }

            }
            
        } 

        catch (IOException e) { 
             System.out.println("ahhh");
        } 
    } 
} 
