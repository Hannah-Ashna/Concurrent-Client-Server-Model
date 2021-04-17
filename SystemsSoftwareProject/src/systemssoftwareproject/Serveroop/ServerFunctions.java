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
    public boolean IDUnique(String ID){
        String ID_entered = ID;
        int amount_of_weatherstations = weatherStations.size();
        boolean ID_unique = true;
        for (int i = 0; i < amount_of_weatherstations; i++){
            WeatherStationType ws = weatherStations.get(i);
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
