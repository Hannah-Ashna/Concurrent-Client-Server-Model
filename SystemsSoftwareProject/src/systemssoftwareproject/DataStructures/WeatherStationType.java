package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class WeatherStationType implements Serializable {
    public final LinkedList<SampleType> samples = new LinkedList<>();
    public String ID = "ID is being Configured";
    
    public String getID(){
        return ID;
    }
    
    public void setID(String id){
        this.ID = id;
    }  
    public WeatherStationType(){
    }
   
    
    public void addSample(SampleType sample){
        if(sampleCount() == 30){
            samples.removeLast();
        }
        samples.add(sample);
        
    }
    public int sampleCount(){
        return samples.size();
    }
   
}
    
