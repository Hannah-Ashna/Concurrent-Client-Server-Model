/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.WeatherStation;

import java.util.Random;

/**
 *
 * @author ryan
 */
public class Location {
        
    public static double getGpsLat(){
        // will get the gps latitiude and return it
        return 52.329250;
    }
    
    public static double getGpsLong(){
        //will get the gps longitude and return it in 
        return -0.185360;
    }
    
    public static double getGpsAltitude(){
        double start = 10;
        double end = 50;
        double random = new Random().nextDouble();
        double result = start + (random * (end - start));
        return result;
    }
    
}
