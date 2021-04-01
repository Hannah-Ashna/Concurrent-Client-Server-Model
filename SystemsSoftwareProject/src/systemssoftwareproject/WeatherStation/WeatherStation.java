package systemssoftwareproject.WeatherStation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.wscom;

public class WeatherStation extends WeatherInstruments {
    private Scanner in;
    private ObjectOutputStream  out;
    public WeatherStation(){ 
    }

    public static void main(String[] args) throws IOException {
        System.out.println("WS-Client\n");
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.run();
    }
    public void run() throws IOException {
        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9091);

        //var scanner = new Scanner(System.in);
        in =  new Scanner(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        while(true){
            while (in.hasNextLine()) {
                RecieveRequest();
            }
        }
        // Process all messages from server, according to the protocol. 
    }
    private void SendID() throws IOException{
        String weatherStationID = "test";//UUID.randomUUID().toString(); 
        System.out.println("WeatherStationID = " + weatherStationID);
        out.writeInt(1);
        out.writeObject(weatherStationID);
    }
    

    private void RecieveRequest() throws IOException{
        String line = in.nextLine();
        if(line.startsWith(wscom.SEND)){
            out.writeInt(0);
            out.writeObject(getSample());
            System.out.println("SAMPLE has been sent");
            }else if(line.startsWith(wscom.SAMPLECONFIRM)){
                System.out.println("Sample was received\n");
        }
        else if (line.startsWith(wscom.SENDID)){
            SendID();
            System.out.println("Sending ID");
        }
        else if ((line.startsWith(wscom.IDCONFIRMED))){
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
