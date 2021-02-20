/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * This class will contain the data which will be serialized to send over TCP to be reassembled
 * @author Nicholas McCaig
 */
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
    @Override
    public String toString(){
        return "Sample{" + "temprature=" + temprature + ", humidity=" + humidity + ", gpsLatitude=" + gpsLatitude + ", gpsLongitdue:" + gpsLongitude + ", altitude:" + altitude + ", sampleDateTime:"+ sampleDateTime + "}";
    }
    


}
