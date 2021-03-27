package systemssoftwareproject.DataStructures;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class WeatherStationType extends ClientType implements Serializable {
    private final LinkedList<SampleType> samples = new LinkedList<>();
    public WeatherStationType(){
    }
    
    @Override
    public String toString(){
        return "WeatherStation{ID= " + ID + "}";
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
    
