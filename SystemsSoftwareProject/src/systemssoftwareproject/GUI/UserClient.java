package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UserClient extends JFrame implements ActionListener {
    
    // Components
    private final Container c;
    private final JLabel title;
    private final JLabel WSData, GPSData, TempData, HumidityData;
    private final JTextArea display, GPSDisp, TempDisp, HumidityDisp;
    
    
    // Other Variables
    static String data = null;
    static String receivedData = null;
    String GPSVal, TempVal, HumidityVal;
    String[] weatherStationIDs = {"", "xyz", "qrs", "efg", "abc"};
    
    
    public UserClient() {
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
        
        JComboBox IDList = new JComboBox(weatherStationIDs);
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
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        
        JComboBox IDList = (JComboBox)e.getSource();
        String IDNum = (String)IDList.getSelectedItem();
        
        // This is temporary just to set data and test the dropdown menu
        // Values should be used later on to store retrieved values
        data = IDNum; // This the variable that gets sent to the server
        
        TempVal = IDNum;
        GPSVal = IDNum;
        HumidityVal = IDNum;
        
        
        //double temp_val = systemssoftwareproject.WeatherStation.WeatherInstruments.getTemp();
        //double humidity_val = systemssoftwareproject.WeatherStation.WeatherInstruments.getHumidity();
        
        //double lat = systemssoftwareproject.WeatherStation.WeatherInstruments.getGpsLat();
        //double lon = systemssoftwareproject.WeatherStation.WeatherInstruments.getGpsLong();
        //double altitude = systemssoftwareproject.WeatherStation.WeatherInstruments.getGpsAltitude();
        
        //display.setText("\n Selected Weather Station ID: " + data);
        //GPSDisp.setText("\n GPS Value: " + lat + "." + lon + "." + altitude);
        //TempDisp.setText("\n Temp Value: " + temp_val + "ºC");
        //HumidityDisp.setText("\n Humidity Value: " + humidity_val + "%");
        
    }
    
    
    public static String sendData(){
        return data;
    }
    
    public static void receivedData(String data){
        receivedData = data;
        
    }
    
    public static void resetData(){
        data = null;
    }
    
    
}