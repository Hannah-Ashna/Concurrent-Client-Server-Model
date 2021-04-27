package systemssoftwareproject.DataStructures;

import java.time.LocalDateTime;
import java.io.Serializable;

public  class SampleType implements Serializable {

    double temperature;

    double humidity;

    double gpsLatitude;

    double gpsLongitude;

    double altitude;
    
    int crops;

    LocalDateTime sampleDateTime = LocalDateTime.now();


    public SampleType(double temp, double humid, double gpsLat, double gpsLong, double alt, int cropsID, LocalDateTime sampleDT) {
    temperature = temp;
    humidity = humid;
    gpsLatitude = gpsLat;
    gpsLongitude = gpsLong;
    altitude = alt;
    sampleDateTime = sampleDT;
    crops = cropsID;
    }

    public SampleType() {
    }
    
    public double getHumid(){
        return humidity;
    }
    
    public double getTemp(){
        return temperature;
    }
    
    public int cropsID(){
        return crops;
    }
    
    public double getGPSLat(){
        return gpsLatitude;
    }
    
    public double getGPSLong(){
        return gpsLongitude;
    }
    
    public double getAltitude(){
        return altitude;
    }
    
    @Override
    public String toString(){
        return "Sample{" + "temprature=" + temperature + ", humidity=" + humidity + ", gpsLatitude=" + gpsLatitude + ", gpsLongitdue:" + gpsLongitude + ", altitude:" + altitude + ", sampleDateTime:"+ sampleDateTime + "}";
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.temperature) ^ (Double.doubleToLongBits(this.temperature) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.humidity) ^ (Double.doubleToLongBits(this.humidity) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.gpsLatitude) ^ (Double.doubleToLongBits(this.gpsLatitude) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.gpsLongitude) ^ (Double.doubleToLongBits(this.gpsLongitude) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.altitude) ^ (Double.doubleToLongBits(this.altitude) >>> 32));

        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SampleType other = (SampleType) obj;
        if (Double.doubleToLongBits(this.temperature) != Double.doubleToLongBits(other.temperature)) {
            return false;
        }
        if (Double.doubleToLongBits(this.humidity) != Double.doubleToLongBits(other.humidity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gpsLatitude) != Double.doubleToLongBits(other.gpsLatitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gpsLongitude) != Double.doubleToLongBits(other.gpsLongitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.altitude) != Double.doubleToLongBits(other.altitude)) {
            return false;
        }
        return true;
    }

}
