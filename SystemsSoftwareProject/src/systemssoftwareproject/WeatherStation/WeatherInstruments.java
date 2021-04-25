package systemssoftwareproject.WeatherStation;

import systemssoftwareproject.DataStructures.SampleType;
import java.util.Random;

// These functions are syncronus we assume that the data will be immidatly returned.
import java.time.LocalDateTime;

public class WeatherInstruments{

    public WeatherInstruments(String loc_in_radius) {
    }
    /**
     * 
     * @return sample
     */
    public SampleType getSample(){
        //Generate random values between a range for the longitude/latitude value parameters
        Random r = new Random();
        double min = 13.0;
        double max = 100.0;
        double randomValue = min + (max - min) * r.nextDouble();
        int lower = 10;
        int upper = 100;
        int rad = (int) (Math.random() * (upper - lower)) + lower;

        double Temprature = climate.getTemp();

        double Humidity = climate.getHumidity();

        double gpsLatitude = Location.getGpsLat(randomValue, randomValue, rad);

        double gpsLongitude = Location.getGpsLong(randomValue, randomValue, rad);

        double altitude = Location.getGpsAltitude();

        LocalDateTime sampleDateTime = LocalDateTime.now();

        
        SampleType sample;
        sample = new SampleType(Temprature,Humidity,gpsLatitude,gpsLongitude,altitude,sampleDateTime);
        return sample;
    }
}
