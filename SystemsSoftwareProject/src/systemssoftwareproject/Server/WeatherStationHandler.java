package systemssoftwareproject.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherStationHandler implements Runnable { 
    private final Socket weatherStationSocket; 
  
    // Constructor 
    public WeatherStationHandler(Socket socket){ 
        this.weatherStationSocket= socket; 
    } 

    @Override
    public void run(){ 
        try {    
            while(true){
                // Create IO Streams
                DataInputStream fromWeatherStation = new DataInputStream(weatherStationSocket.getInputStream());
                DataOutputStream toWeatherStation = new DataOutputStream(weatherStationSocket.getOutputStream());   
                
                try {
                    String text = fromWeatherStation.readUTF();
                    toWeatherStation.writeUTF(text.toUpperCase());
                    System.out.println(text);
                                     
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
