package systemssoftwareproject.WeatherStation;

import java.util.Random;

public class climate {
    
    private static double temp = 23.1; 

    public static double getTemp(){
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
    
    public static double getHumidity(){
        double rangeMin = 17.5;
        double rangeMax = 19.8;
        //Will request the humidity from the device and return the humidity
        Random r = new Random();
        double hum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        
        return hum;
    }
    
}
