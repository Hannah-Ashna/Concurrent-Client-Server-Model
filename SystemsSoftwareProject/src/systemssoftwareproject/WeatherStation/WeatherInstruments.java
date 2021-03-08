package systemssoftwareproject.WeatherStation;

//These functions are syncronus we assume that the data will be immidatly returned.

import java.time.LocalDateTime;
import systemssoftwareproject.DataStructures.SampleType;

public class WeatherInstruments{
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

        LocalDateTime sampleDateTime = LocalDateTime.now();

    
        SampleType sample;
        sample = new SampleType(Temprature,Humidity,gpsLatitude,gpsLongitude,altitude,sampleDateTime);
        return sample;
    }

}
