package systemssoftwareproject.WeatherStation;

import java.util.Random;

public class Location {

    // Generate and return a Latitiude value
    public static double getGpsLat(double x0, double y0, int radius){
        Random random = new Random();
        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        double foundLatitude = y + y0;
        
        return foundLatitude;
    }
    
    // Generate and return a Longitude value
    public static double getGpsLong(double x0, double y0, int radius){
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

        double foundLongitude = new_x + x0;
 
        return foundLongitude;
    }
    
    // Generate and return an Altitude value between 10-50
    public static double getGpsAltitude(){
        Random r = new Random();
        int low = 10;
        int high = 50;
        int result = r.nextInt(high - low) + low;
        return result;
    }
    
}
