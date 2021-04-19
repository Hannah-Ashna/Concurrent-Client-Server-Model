package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WSSTYPE;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.User.User;
public class UserClient extends JFrame implements ActionListener {
    
    // Components
    private final Container c;
    private final JLabel title;
    private final JLabel WSData, GPSData, TempData, HumidityData, AltData;
    private final JTextArea display, GPSDisp, TempDisp, HumidityDisp, AltDisp;
    private JComboBox IDList;
    private final JButton graph;
    
    private User user;
    // Other Variables
    String GPSVal, TempVal, HumidityVal;
    String wsIDs[]={"None Connected"};
    
    public UserClient(User user) throws InterruptedException {
        this.user = user;
        setTitle("User Client");
        setBounds(300, 90, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        title = new JLabel("Dashboard:");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(50, 20);
        c.add(title);
        
        IDList = new JComboBox(wsIDs);
        IDList.setSelectedIndex(0);
        IDList.addActionListener(this);
        IDList.setSize(100,30);
        IDList.setLocation(650, 20);
        c.add(IDList);
        
        WSData = new JLabel("Data Output:"); 
        WSData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        WSData.setSize(200, 20); 
        WSData.setLocation(50, 70); 
        c.add(WSData);
        
        display = new JTextArea();
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(250, 400);
        display.setLocation(50, 100);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setText("\n Select a Weather Station");
        c.add(display);
        
        GPSData = new JLabel("GPS Coordinates:"); 
        GPSData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        GPSData.setSize(200, 20); 
        GPSData.setLocation(350, 70); 
        c.add(GPSData); 
        
        GPSDisp = new JTextArea();
        GPSDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        GPSDisp.setSize(250, 50);
        GPSDisp.setLocation(350, 100);
        GPSDisp.setLineWrap(true);
        GPSDisp.setEditable(false);
        GPSDisp.setText(" ");
        c.add(GPSDisp);
        
        TempData = new JLabel("Temperature:"); 
        TempData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        TempData.setSize(200, 20); 
        TempData.setLocation(350, 170); 
        c.add(TempData);
        
        TempDisp = new JTextArea();
        TempDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        TempDisp.setSize(250, 50);
        TempDisp.setLocation(350, 200);
        TempDisp.setLineWrap(true);
        TempDisp.setEditable(false);
        TempDisp.setText(" ");
        c.add(TempDisp);
        
        HumidityData = new JLabel("Humidity Levels:"); 
        HumidityData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        HumidityData.setSize(200, 20); 
        HumidityData.setLocation(350, 270); 
        c.add(HumidityData);
        
        HumidityDisp = new JTextArea();
        HumidityDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        HumidityDisp.setSize(250, 50);
        HumidityDisp.setLocation(350, 300);
        HumidityDisp.setLineWrap(true);
        HumidityDisp.setEditable(false);
        HumidityDisp.setText(" ");
        c.add(HumidityDisp);
        
        AltData = new JLabel("Altitude:"); 
        AltData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        AltData.setSize(200, 20); 
        AltData.setLocation(350, 370); 
        c.add(AltData);
        
        AltDisp = new JTextArea();
        AltDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        AltDisp.setSize(250, 50);
        AltDisp.setLocation(350, 400);
        AltDisp.setLineWrap(true);
        AltDisp.setEditable(false);
        AltDisp.setText(" ");
        c.add(AltDisp);
        
        graph = new JButton("Graph"); 
        graph.setFont(new Font("Arial", Font.PLAIN, 15)); 
        graph.setSize(100, 20); 
        graph.setLocation(350, 470); 
        graph.addActionListener(this); 
        c.add(graph);
        
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                user.closeProgram();
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed (ActionEvent e){        
        JComboBox IDList = (JComboBox)e.getSource();
        String ID = IDList.getSelectedItem().toString(); 
            try {
                user.requestStation(ID);
            } catch (InterruptedException ex) {
            }
        WeatherStationType ws;
        ws =  user.weatherStationList.getByID(ID);
        System.out.println(ws + "action");
        display.setText("\n Selected Weather Station ID: " + ws.getID());
        HumidityDisp.setText(" " + String.valueOf(ws.samples.getLast().getHumid()));
        TempDisp.setText(" " + String.valueOf(ws.samples.getLast().getTemp()));
        GPSDisp.setText(" Latitude: " + String.valueOf(ws.samples.getLast().getGPSLat()) + " Longitude: " + String.valueOf(ws.samples.getLast().getGPSLong()));
        AltDisp.setText(" " + String.valueOf(ws.samples.getLast().getAltitude()));
    
    }
    
    public void updateWSList() throws InterruptedException{
        c.remove(IDList);
        IDList = new JComboBox(user.getIds().toArray());
        System.out.println("Testing: " + user.getIds());
        IDList.setSelectedIndex(0);
        IDList.addActionListener(this);
        IDList.setSize(100,30);
        IDList.setLocation(650, 20);
        c.add(IDList);
        c.revalidate();
        c.repaint();
    }
    
    public void updateDataDisp () throws InterruptedException{
        String ID = IDList.getSelectedItem().toString();
        user.updateSelectedStation(ID);
        user.requestStation(ID);
        WeatherStationType ws;
        try{
        ws =  user.weatherStationList.getByID(ID);
        }catch(Exception e) {
            TimeUnit.SECONDS.sleep(1);
            ws =  user.weatherStationList.getByID(ID);

        }
        display.setText("\n Selected Weather Station ID: " + ws.getID());
        HumidityDisp.setText(" " + String.valueOf(ws.samples.getLast().getHumid()));
        TempDisp.setText(" " + String.valueOf(ws.samples.getLast().getTemp()));
        GPSDisp.setText(" Latitude: " + String.valueOf(ws.samples.getLast().getGPSLat()) + " Longitude: " + String.valueOf(ws.samples.getLast().getGPSLong()));
        AltDisp.setText(" " + String.valueOf(ws.samples.getLast().getAltitude()));
    }
    
    
    public static void drawGraph () throws Exception{
        
        double phase = 0;
        double[][] initdata = getSineData(phase);

        // Create Chart
        final XYChart chart = QuickChart.getChart("Simple XChart Real-time Demo", "Radians", "Sine", "sine", initdata[0], initdata[1]);

        // Show it
        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        sw.displayChart();

        while (true) {

          phase += 2 * Math.PI * 2 / 20.0;

          Thread.sleep(100);

          final double[][] data = getSineData(phase);

          chart.updateXYSeries("sine", data[0], data[1], null);
          sw.repaintChart();
        }

    }
    
    
    private static double[][] getSineData(double phase) {

        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double radians = phase + (2 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(radians);
        }
        return new double[][] { xData, yData };
    }
 }