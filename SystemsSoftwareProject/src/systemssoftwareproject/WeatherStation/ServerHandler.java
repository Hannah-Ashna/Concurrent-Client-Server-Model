package systemssoftwareproject.WeatherStation;

import systemssoftwareproject.DataStructures.SampleType;

public class ServerHandler {

    /**
     * on the event the weather station receives a request it will generate a response.
     */
    public void RecieveRequest(){
        
    }
    
    /**
     *  send the sample data to the server
     */
    public void SendNewSampleData(){
        SampleType test = new SampleType();
        //send the new sample to the server via the socket 
    }
}
