/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nicholas McCaig
 */
public class WSSTYPE implements Serializable{
    public List<WeatherStationType> weatherStations =  Collections.synchronizedList(new ArrayList<>()); 
}
