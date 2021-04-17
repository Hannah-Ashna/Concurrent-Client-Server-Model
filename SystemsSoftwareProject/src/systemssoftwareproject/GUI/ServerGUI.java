package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.Serveroop.Server;


public class ServerGUI extends JFrame implements ActionListener {
   // Components
    private final Container c;
    private final JLabel users, ws;
    private final JTextArea userDisp, wsDisp;
    
    // Variables
    int WSCount = 0;
    int UserCount = 0;
    
    public ServerGUI(Server server) {
        setTitle("Server");
        setBounds(300, 90, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        users = new JLabel("Connected User Clients:"); 
        users.setFont(new Font("Arial", Font.PLAIN, 20)); 
        users.setSize(400, 100); 
        users.setLocation(50, 0);
        c.add(users);
        
        userDisp = new JTextArea();
        userDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        userDisp.setSize(300, 400);
        userDisp.setLocation(50, 70);
        userDisp.setLineWrap(true);
        userDisp.setEditable(false);
        userDisp.setText("No User-Clients Connected");
        c.add(userDisp);
        
        ws = new JLabel("Connected Weather Clients:"); 
        ws.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ws.setSize(400, 100); 
        ws.setLocation(400, 0); 
        c.add(ws);
        
        wsDisp = new JTextArea();
        wsDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        wsDisp.setSize(300, 400);
        wsDisp.setLocation(400, 70);
        wsDisp.setLineWrap(true);
        wsDisp.setEditable(false);
        wsDisp.setText("No WS-Clients Connected");
        c.add(wsDisp);
        
        setVisible(true);
    }
    
    
    public void getClients(Server server) throws InterruptedException{
        WSCount = server.wsCount();
        UserCount = server.userCount();
        String wsDispData = "";
        String userDispData = "";
        c.remove(wsDisp);
        c.remove(userDisp);
        
        userDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        userDisp.setSize(300, 400);
        userDisp.setLocation(50, 70);
        userDisp.setLineWrap(true);
        userDisp.setEditable(false);
        userDispData = "User Clients "+ UserCount + "\n";
        userDisp.setText(userDispData);
        c.add(userDisp);
        
        wsDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        wsDisp.setSize(300, 400);
        wsDisp.setLocation(400, 70);
        wsDisp.setLineWrap(true);
        wsDisp.setEditable(false);
        
        for (WeatherStationType currentws : server.weatherStations) {
            wsDispData += "Weather Station " + currentws.getID() + "\n";
        }   
            wsDisp.setText(wsDispData);
            c.add(wsDisp);
            
            c.revalidate();
            c.repaint();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
