/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Serveroop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WeatherStationType;

/**
 *
 * @author Nicholas McCaig
 */
public class ServerFunctions {
       public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
       public List<UserType> users =  Collections.synchronizedList(new ArrayList<>()); 
       public int wsCount() {
    return weatherStations.size();
}

}
