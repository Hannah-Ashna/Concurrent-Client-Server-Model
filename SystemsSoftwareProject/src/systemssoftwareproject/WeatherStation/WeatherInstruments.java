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
        } else {
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
    
    public double getHumidity(){
        //Will request the humidity from the device and return the humidity
        double hum = (temp - 5);
        Random h = new Random();
        if (hum > 35.0){
            hum = 33.0;
        } else {
            //Get random number, decides if value increases or decreases.
            int val = h.nextInt();
            if (val < 0) {
                    hum += 4;
            } else {
                    hum -= 4;
            }
        }
        return hum;
    }
    
    /*
    //Function generates random latatuide/longitude within a radius - call genLongitude and genLatitude 
    public static void genLocation(double x0, double y0, int radius) {
    Random random = new Random();

    // Convert radius from meters to degrees
    double radiusInDegrees = radius / 111000f;

    double u = random.nextDouble();
    double v = random.nextDouble();
    double w = radiusInDegrees * Math.sqrt(u);
    double t = 2 * Math.PI * v;
    double x = w * Math.cos(t);
    double y = w * Math.sin(t);

    // Adjust the x-coordinate for the shrinking of the east-west distances
    double new_x = x / Math.cos(Math.toRadians(y0));

    double genLongitude = new_x + x0;
    double genLatitude = y + y0;
    
    }
    */
    
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
