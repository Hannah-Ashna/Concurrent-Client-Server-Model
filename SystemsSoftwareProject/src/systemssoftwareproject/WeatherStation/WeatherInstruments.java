package systemssoftwareproject.WeatherStation;

//These functions are syncronus we assume that the data will be immidatly returned.

import java.time.LocalDateTime;
import systemssoftwareproject.DataStructures.SampleType;
import java.util.Random;

public class WeatherInstruments{

    private double temp = 23.1; 

    public double getTemp(){
        //Communicate with thermostat and return on request the current temperature.
            Random t = new Random();
            if (temp > 35.0){
                temp = 33.0;
            }else{
                //Get random number, decides if value increases or decreases.
                int num = t.nextInt();
                if (num < 0) {
                        temp += 0.5;
                } else {
                        temp -= 0.5;
                }
            }
            return temp;
    }
    
    public double getHumidity(){ //Value is a percentage(%)
        // Will request the humidity from the device and return the humidity
        double humidity = 80;
        Random hum = new Random();
        // Get random number, decides if value increases or decreases.
        int num = hum.nextInt();
        if (num < 0) {
                humidity += 2.7;
        } else {
                humidity -= 5.7;
        }
        // If value exceeds 100%  - reinitialise 
        if( humidity >= 100 ){
            humidity = 82;
        }
        return humidity;
    }
    
    public double getRainfall(){
        // Will request the rainfall level from the device and return the level.
        double rainfall = 15.0;
        Random rain = new Random();
        //Get random number, decides if value increases or decreases.
        int num = rain.nextInt();
        if (num < 0) {
                rainfall += 0.35;
        } else {
                rainfall -= 0.21;
        }
        return Math.round(rainfall * 100.0) / 100.0;
    }
    
    public double getGpsLat(){
        // will get the gps latitiude and return it
        return 52.329250;
    }
    public double getGpsLong(){
        //will get the gps longitude and return it in 
        return -0.185360;
    }
    public double getGpsAltitude(){
        
        return 5;
    }

    /**
     * 
     * @return sample
     */
    public SampleType getSample(){
        double Temprature = getTemp();

        double Humidity = getHumidity();

        double gpsLatitude = getGpsLat();

        double gpsLongitude = getGpsLong();

        double altitude = getGpsAltitude();
        
        double Rain = getRainfall();

        LocalDateTime sampleDateTime = LocalDateTime.now();

    
        SampleType sample;
        sample = new SampleType(Temprature,Humidity,gpsLatitude,gpsLongitude,altitude,sampleDateTime,Rain);
        return sample;
    }

}
