package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ServerGUI extends JFrame implements ActionListener {
   // Components
    private final Container c;
    private final JLabel users, ws;
    private final JTextArea userDisp, wsDisp;
    
    // Variables
    int WSCount = 0;
    int UserCount = 0;
    
    public ServerGUI() {
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
    
    
    public void getClients(int wsCount, int userCount){
        WSCount = wsCount;
        UserCount = userCount;
        String wsDispData = "";
        String userDispData = "";
        c.remove(wsDisp);
        c.remove(userDisp);
        
        userDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        userDisp.setSize(300, 400);
        userDisp.setLocation(50, 70);
        userDisp.setLineWrap(true);
        userDisp.setEditable(false);
        for (int i = 0; i < UserCount; i++){
            userDispData += "User Client " + (i+1) + "\n";
        }
        userDisp.setText(userDispData);
        c.add(userDisp);
        
        wsDisp.setFont(new Font("Arial", Font.PLAIN, 15));
        wsDisp.setSize(300, 400);
        wsDisp.setLocation(400, 70);
        wsDisp.setLineWrap(true);
        wsDisp.setEditable(false);
        
        String file_name = "WeatherStationID_List.txt"; 
        try {
            FileReader fin = new FileReader(file_name);
            BufferedReader din = new BufferedReader(fin);
            
            // Read from the file
            String line = null; // line of text
            while ((line = din.readLine()) != null) {
                // Here we have read in a line of text
                StringTokenizer st = new StringTokenizer(line);
                String weather_station_ID = (st.nextToken().trim());
                wsDispData += "Weather Station " + line + "\n";
            }
            // Close the stream
            din.close(); 
        } catch (IOException e) {
            System.err.println("Error! - " + e.getMessage());
        }
        
        //for (int j = 0; j < WSCount; j++){
        //    wsDispData += "Weather Station " + (j+1) + "\n";
        //}
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
