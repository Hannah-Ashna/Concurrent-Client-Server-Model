/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;

import java.time.LocalDateTime;

/**
 * This class will contain the data which will be serialized to send over TCP to be reassembled
 * @author Nicholas McCaig
 */
public  class SampleType {

    double Temprature;

    double Humidity;

    double gpsLatitude;

    double gpsLongitude;

    double altitude;

    LocalDateTime sampleDateTime = LocalDateTime.now();


    public SampleType(double temp, double humid, double gpsLat, double gpsLong, double alt, LocalDateTime sampleDT) {
    Temprature = temp;
    Humidity = humid;
    gpsLatitude = gpsLat;
    gpsLongitude = gpsLong;
    altitude = alt;
    sampleDateTime = sampleDT;

    }
    


}
