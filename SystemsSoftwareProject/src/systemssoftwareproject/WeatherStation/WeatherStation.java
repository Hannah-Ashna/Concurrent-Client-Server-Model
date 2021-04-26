package systemssoftwareproject.WeatherStation;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import systemssoftwareproject.DataStructures.wscom;

public class WeatherStation extends WeatherInstruments {
    private Scanner in;
    private ObjectOutputStream  out;
    public WeatherStation(){ 
        super("Loc in radius");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("WS-Client\n");
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.run();
    }
    
    public void run() throws IOException, InterruptedException {
        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9091);

        //var scanner = new Scanner(System.in);
        in =  new Scanner(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        while(true){
            while (in.hasNextLine()) {
                ReceiveRequest();
            }
        }
        // Process all messages from server, according to the protocol.
    }
    
    private void SendID() throws IOException, InterruptedException{
        String weatherStationID = UUID.randomUUID().toString(); //Generates a unique ID 
        System.out.println("WeatherStationID = " + weatherStationID);
        out.writeInt(1); //Tells server what data to expect from weatherstation
        out.writeObject(weatherStationID); //Sends ID as string Object stream
        
    }
    

    private void ReceiveRequest() throws IOException, InterruptedException{
        String line = in.nextLine();
        if(line.startsWith(wscom.SEND)){
            out.writeInt(0);
            out.writeObject(getSample());
            System.out.println("SAMPLE has been sent");
            }else if(line.startsWith(wscom.SAMPLECONFIRM)){
                System.out.println("Sample was received\n");
                TimeUnit.SECONDS.sleep(30);
        }
        else if (line.startsWith(wscom.SENDID)){ //If message from server is to send the ID then....
            SendID(); // Run Send the ID function 
            System.out.println("Sending ID");
        }
        else if ((line.startsWith(wscom.IDCONFIRMED))){ //Once ID has been confirmed
            System.out.println("ID had been accepted");
        }

        else{
            System.out.println(line);
            System.out.println("The client received an invalid command!");
        }
    }
    
    /**
     *  send the sample data to the server
     */
    public void SendNewSampleData(){
        //send the new sample to the server via the socket 
    }  
}
