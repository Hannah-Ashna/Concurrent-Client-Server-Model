package systemssoftwareproject.DataStructures;

import java.time.LocalDateTime;
import java.io.Serializable;

public  class SampleType implements Serializable {

    double temprature;

    double humidity;

    double gpsLatitude;

    double gpsLongitude;

    double altitude;

    LocalDateTime sampleDateTime = LocalDateTime.now();


    public SampleType(double temp, double humid, double gpsLat, double gpsLong, double alt, LocalDateTime sampleDT) {
    temprature = temp;
    humidity = humid;
    gpsLatitude = gpsLat;
    gpsLongitude = gpsLong;
    altitude = alt;
    sampleDateTime = sampleDT;

    }

    public SampleType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return "Sample{" + "temprature=" + temprature + ", humidity=" + humidity + ", gpsLatitude=" + gpsLatitude + ", gpsLongitdue:" + gpsLongitude + ", altitude:" + altitude + ", sampleDateTime:"+ sampleDateTime + "}";
    }

}
