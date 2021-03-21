package systemssoftwareproject.DataStructures;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class WeatherStationType extends ClientType implements Serializable {
    private Queue<SampleType> samples = new LinkedList<>();
    public WeatherStationType(){
    }
    
    @Override
    public String toString(){
        return "WeatherStation{ID= " + ID + "}";
    }
    public void addSample(SampleType sample){
        samples.add(sample);
    }
    public SampleType lastSample(){
     return samples.peek();
    }
}
    
