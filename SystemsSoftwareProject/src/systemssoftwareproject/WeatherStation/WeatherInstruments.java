package systemssoftwareproject.WeatherStation;

import systemssoftwareproject.DataStructures.SampleType;
import systemssoftwareproject.WeatherStation.Location;

//These functions are syncronus we assume that the data will be immidatly returned.
import java.time.LocalDateTime;
import java.util.Random;


public class WeatherInstruments{

    public WeatherInstruments(String loc_in_radius) {
    }
    /**
     * 
     * @return sample
     */
    public SampleType getSample(){
        
        double Temprature = climate.getTemp();

        double Humidity = climate.getHumidity();

        double gpsLatitude = Location.getGpsLat();

        double gpsLongitude = Location.getGpsLong();

        double altitude = Location.getGpsAltitude();

        LocalDateTime sampleDateTime = LocalDateTime.now();

        
        SampleType sample;
        sample = new SampleType(Temprature,Humidity,gpsLatitude,gpsLongitude,altitude,sampleDateTime);
        return sample;
    }
}
