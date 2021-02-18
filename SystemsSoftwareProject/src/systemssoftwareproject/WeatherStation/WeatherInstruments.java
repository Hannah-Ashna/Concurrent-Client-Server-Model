/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.WeatherStation;

//These functions are syncronus we assume that the data will be immidatly returned.
public class WeatherInstruments extends Main {
    public double getTemp(){
        //will communicate with 'thermostat' and return the current temprature on request 
        return 10.1;
    }
    public double getHumidity(){
        //Will request the humidity from the device and return the humidity
        return 50.5;
    }
    public double getGpsLat(){
        // will get the gps latitiude and return it
        return 52.329250;
    }
    public double getGpsLong(){
        //will get the gps longitudde and return it in 
        return -0.185360;
    }
    public double getGpsAltitude(){
        
        return 5;
    }
}
