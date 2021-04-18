package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WSSTYPE implements Serializable{
    public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new LinkedList<>()); 
    
    public int wsCount(){
        return weatherStations.size();
    }
    public WeatherStationType getByID(String ID){
        for (WeatherStationType weatherStation : weatherStations) {
         if(weatherStation.getID().equals(ID)){
             return weatherStation;
         }   
        }
        return null;
    }
    public void replaceStation(WeatherStationType ws){
        for (WeatherStationType weatherStation : weatherStations) {
         if(weatherStation.ID.equals(ws.ID)){
             weatherStation = ws;
            }
         }
    }
}
