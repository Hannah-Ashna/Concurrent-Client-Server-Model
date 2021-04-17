package systemssoftwareproject.Serveroop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WeatherStationType;

public class ServerFunctions {
    public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
    public List<UserType> users =  Collections.synchronizedList(new ArrayList<>()); 
    
    public int wsCount() {
        return weatherStations.size();
    }
    
    public List wsStationsArray(){
        return weatherStations;
    }
    
    public int userCount() {
        return users.size();
    }
    
    public List usersArray(){
        return users;
    }
}
