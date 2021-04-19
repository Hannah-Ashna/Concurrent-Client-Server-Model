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
             System.out.println(ID + "Testing");
             return weatherStation;
         }   
        }
        return new WeatherStationType();
    }
    public void replaceStation(WeatherStationType ws){
        boolean replaced = false;
        for (WeatherStationType weatherStation : weatherStations) {
         if(weatherStation.ID.equals(ws.ID)){
            weatherStations.remove(weatherStation);
            weatherStations.add(ws);
             replaced = true;
            }
         }
        if(replaced == false){
            weatherStations.add(ws);
        }
    }
}
