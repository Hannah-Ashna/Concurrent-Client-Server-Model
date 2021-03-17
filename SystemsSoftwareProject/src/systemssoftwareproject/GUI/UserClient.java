package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.concurrent.TimeUnit;


public class UserClient extends JFrame implements ActionListener {
    
    // Components
    private final Container c;
    private final JLabel title;
    private final JLabel clientData;
    private final JTextArea display;

    static String data = null;
    static String receivedData = null;
    public UserClient() {
        setTitle("User Client");
        setBounds(300, 90, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Dashboard:");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(50, 20);
        c.add(title);
        
        clientData = new JLabel("Data Output:"); 
        clientData.setFont(new Font("Arial", Font.PLAIN, 20)); 
        clientData.setSize(120, 20); 
        clientData.setLocation(50, 70); 
        c.add(clientData); 
        
        String[] weatherStationIDs = { "123", "456", "789", "abc"};

        JComboBox IDList = new JComboBox(weatherStationIDs);
        IDList.setSelectedIndex(0);
        IDList.addActionListener(this);
        IDList.setSize(100,30);
        IDList.setLocation(650, 20);
        c.add(IDList);
        
        display = new JTextArea();
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(700, 400);
        display.setLocation(50, 100);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setText("Sample");
        c.add(display);
          
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        
        JComboBox IDList = (JComboBox)e.getSource();
        String IDNum = (String)IDList.getSelectedItem();
        data = IDNum;
       
        display.setText("\n Selected Client ID: " + data);
        //try {
            // Freezes the GUI - Not what we want 
            // TimeUnit.SECONDS.sleep(1);
            //display.setText("\n Response from Server: " + receivedData);
        //} catch ( ...) {System.out.println("Thread is interuppted....");}
        //}
        
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
