package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.knowm.xchart.*;

public class Graph extends JFrame implements ActionListener {
    
    // Components
    private Container c;
    
    private LinkedList<Integer> xData =  new LinkedList<Integer>(); 
    private LinkedList<Double>yTempData =  new LinkedList<Double>(); 
    private LinkedList<Double> yHumidData =  new LinkedList<Double>();
    
    public Graph() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        c = new JPanel();
        c.setLayout(new BorderLayout(0, 0));
        setContentPane(c);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
    }
    
    public void createChart(XYChart chart) {
        c.removeAll();
        
        JPanel panelChart = new XChartPanel(chart);
        c.add(panelChart);
        c.revalidate();
        c.repaint();
    }
    
    public void createHistogram(String title, String xTitle, String yTitle, LinkedList<Integer> xDataSet, LinkedList<Double> yTempSet, LinkedList<Double> yHumidSet) {
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title).xAxisTitle(xTitle).yAxisTitle(yTitle).build();
       
        chart.addSeries("Temperature", xDataSet, yTempSet);
        chart.addSeries("Humidity", xDataSet, yHumidSet);
        
        setVisible(true);
        createChart(chart);
    }
    
    public void refreshGraph(ArrayList NewTempData, ArrayList NewHumidData, String Title){
        xData = new LinkedList<Integer>();
        yTempData = new LinkedList<Double>();
        yHumidData = new LinkedList<Double>();
        
        int timeCount = 0;
        
        for (int i = 0; i < NewTempData.size(); i++){
            yTempData.add((double)NewTempData.get(i));
            yHumidData.add((double)NewHumidData.get(i));
            xData.add(timeCount);
            timeCount += 10;
        }
        
        createHistogram("Temperature Graph: " + Title + " WS Client", "Time (seconds)", "Temperature (Celcius)", xData, yTempData, yHumidData);
    }
    
    public void getXData(){
    
    }
    
    public void getYData(){
    
    }
}