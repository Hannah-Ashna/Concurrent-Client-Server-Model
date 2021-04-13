package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WSSTYPE implements Serializable{
    public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
    
    public int wsCount(){
        return weatherStations.size();
    }
    
}
