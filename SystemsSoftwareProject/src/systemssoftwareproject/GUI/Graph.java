//package systemssoftwareproject.GUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import org.knowm.xchart.*;
//
//public class Graph extends JFrame implements ActionListener {
//    
//    // GUI Components & Variables
//    private Container c;
//    private LinkedList<Integer> xData =  new LinkedList<Integer>(); 
//    private LinkedList<Double>yTempData =  new LinkedList<Double>(); 
//    private LinkedList<Double> yHumidData =  new LinkedList<Double>();
//    
//    public Graph() {
//        // Setup a basic GUI template for the Graph
//        // This is updated using the other functions
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 850, 650);
//        c = new JPanel();
//        c.setLayout(new BorderLayout(0, 0));
//        setContentPane(c);
//    }
//    
//    @Override
//    public void actionPerformed (ActionEvent e){
//        // This function is not used but a necessity for JSwing GUIs
//    }
//    
//    public void createChart(XYChart chart) {
//        // Remove the old graph
//        c.removeAll();
//        
//        // Draw on the new graph and revalidate it to be displayed
//        // Allows us to refresh the existing window instead of creating a new one
//        JPanel panelChart = new XChartPanel(chart);
//        c.add(panelChart);
//        c.revalidate();
//        c.repaint();
//    }
//    
//    public void createHistogram(String title, String xTitle, String yTitle, LinkedList<Integer> xDataSet, LinkedList<Double> yTempSet, LinkedList<Double> yHumidSet) {
//        // Declare and setup chart with all its details
//        XYChart chart = new XYChartBuilder().width(800).height(600).title("Temperature & Humidity Graph:").xAxisTitle(xTitle).yAxisTitle(yTitle).build();
//       
//        // Add the two series of data - Temp & Humidity
//        chart.addSeries("Temperature", xDataSet, yTempSet);
//        chart.addSeries("Humidity", xDataSet, yHumidSet);
//        
//        // Replace the GUI's title with the current WSClient's ID
//        setTitle("WS Client: " + title);
//        
//        // Display the chart
//        setVisible(true);
//        createChart(chart);
//    }
//    
//    public void refreshGraph(ArrayList NewTempData, ArrayList NewHumidData, String Title){
//        // Redeclare these variables for overwriting
//        xData = new LinkedList<Integer>();
//        yTempData = new LinkedList<Double>();
//        yHumidData = new LinkedList<Double>();
//        
//        // Time count for time that passes by
//        int timeCount = 0;
//        
//        // Loop through each ArrayList and update them with the new values
//        for (int i = 0; i < NewTempData.size(); i++){
//            yTempData.add((double)NewTempData.get(i));
//            yHumidData.add((double)NewHumidData.get(i));
//            xData.add(timeCount);
//            timeCount += 30;
//        }
//        
//        createHistogram(Title, "Time (seconds)", "Temp & Humidity Values", xData, yTempData, yHumidData);
//    }
//}