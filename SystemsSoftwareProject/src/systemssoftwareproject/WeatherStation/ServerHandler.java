package systemssoftwareproject.WeatherStation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;
import systemssoftwareproject.DataStructures.SampleType;

public class ServerHandler {

    /**
     * on the event the weather station receives a request it will generate a response.
     */
    public void RecieveRequest(){
        
    }
    
    public void CreateIDNum(){
   
    
    }
    /**
     *  send the sample data to the server
     */
    public void SendNewSampleData(){
        SampleType test = new SampleType();
        //send the new sample to the server via the socket 
    }
    
    public static void main(String[] args) {
        boolean ID_unique = false;
        System.out.println("WS-WeatherStation\n");
        
        try (Socket socket = new Socket("127.0.0.2", 1234)) { 
          while(true){
            while(ID_unique == false){
                String weatherStationID = UUID.randomUUID().toString();   
                // Create IO Streams
                DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());

                System.out.println("Sending server message:" + weatherStationID);
                toServer.writeUTF(weatherStationID);


                String text = fromServer.readUTF();
                System.out.println("Received server message:" + text);
                if (text.equals("ID has been added")){
                    ID_unique = true;
                    
                }
                
            }  }
        }

        catch (IOException e) { 
        }
    }
}

    
    


