/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;
import java.io.Serializable;
import java.util.LinkedList;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Nicholas McCaig
 */
interface WeatherStation{
    public String getID();
}
public class WeatherStationType implements WeatherStation,Serializable {
    private SampleType lastSample;
    
    @Override
    public String getID(){
        //To be implemented 
        return "TestID";
    }
    public SampleType getLastSample(){
        return lastSample;
    }
    @Override
    public String toString(){
        return "WeatherStation{lastSample= " + lastSample + "}";
    }
    
}
