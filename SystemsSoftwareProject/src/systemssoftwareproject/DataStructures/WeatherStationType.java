package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import systemssoftwareproject.Serveroop.Server;


public class WeatherStationType implements Serializable {
    public final LinkedList<SampleType> samples = new LinkedList<>();
    public String ID = "TestID";
    private WSSTYPE WeatherStationList;
    
    public String getID(){
        return ID;
    }
    
    public void setID(String id){
        this.ID = id;
    }  
    
    public WeatherStationType(){
    }
    
    @Override
    public String toString(){
        return "WeatherStation{ID= " + ID + "I have samples need to be implimented!"+"}";
    }
    
    public void addSample(SampleType sample){
        if(sampleCount() == 30){
            samples.removeLast();
        }
        samples.add(sample);
    }
    
    public int sampleCount(){
        return samples.size();
    }
    
    public boolean IDUnique(String ID){
        String ID_entered = ID;
        int amount_of_weatherstations = WeatherStationList.wsCount();
        boolean ID_unique = true;
        for (int i = 0; i < amount_of_weatherstations; i++){
            WeatherStationType ws =  WeatherStationList.weatherStations.get(i);
            String ID_found = ws.getID();
            if (ID_entered.equals(ID_found)){
                ID_unique = false;
                break;
            }
            break;
        }
        return ID_unique;
    }

}
    
