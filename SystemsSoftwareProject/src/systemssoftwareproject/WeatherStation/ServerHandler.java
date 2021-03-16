package systemssoftwareproject.WeatherStation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.GUI.UserClient;

public class ServerHandler {

    /**
     * on the event the weather station receives a request it will generate a response.
     */
    public void RecieveRequest(){
        
    }
    
    public void SendIDNum(){
    
    
    }
    /**
     *  send the sample data to the server
     */
    public void SendNewSampleData(){
        SampleType test = new SampleType();
        //send the new sample to the server via the socket 
    }
    
     public static void main(String[] args) {
        System.out.println("WS-Client\n");
        
        
                   try (Socket socket = new Socket("localhost", 1234)) { 
                while(true){
                    // Create IO Streams
                    DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                    DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                    
                    if (UserClient.sendData() != null){
                        System.out.println("Sending server message:");
                        toServer.writeUTF(UserClient.sendData());

                        
                        String text = fromServer.readUTF();
                        System.out.println("Received server message:");
                        UserClient.receivedData(text);
                        
                        UserClient.resetData();                        
                    }
                }
            }
            
            catch (IOException e) { 
            }
        }
    } 

    
    


