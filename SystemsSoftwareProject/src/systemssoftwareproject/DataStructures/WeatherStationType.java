/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;
import java.util.LinkedList;
/**
 *
 * @author Nicholas McCaig
 */
interface WeatherStation{
    public String getID();
}
public class WeatherStationType implements WeatherStation {
    LinkedList<SampleType> samples = new LinkedList<>();
    
    @Override
    public String getID(){
        //To be implemented 
        return "TestID";
    }
    
}
