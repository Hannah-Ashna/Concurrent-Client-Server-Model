package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import systemssoftwareproject.DataStructures.UserType;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.Serveroop.Server;


public class ServerGUI extends JFrame implements ActionListener {
   
    // GUI Components & Variables
    private final Container c;
    private final JLabel users, ws;
    private final JTextArea userDisp, wsDisp;
    
    public ServerGUI(Server server) {
        // Setup a basic GUI template for the Server's GUI
        // This is updated using the other functions
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
        String wsDispData = "";
        String userDispData = "";
        
        // Remove old user Display to be replaced with new ones
        c.remove(wsDisp);
        c.remove(userDisp);
        
        // Update & Display User Clients
        userDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        userDisp.setSize(300, 400);
        userDisp.setLocation(50, 70);
        userDisp.setLineWrap(true);
        userDisp.setEditable(false);
        
        for (UserType current_users : server.users) {
            userDispData += "User client " + current_users.getUsername() + "\n";
        }
        
        userDisp.setText(userDispData);
        c.add(userDisp);
        
        // Update & Display Weather Station Clients
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
        
        // Refresh GUI to showcase updates
        c.revalidate();
        c.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet."); 
    } 
}
