package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ServerGUI extends JFrame implements ActionListener {
   // Components
    private final Container c;
    private final JLabel users, ws;
    private final JTextArea userDisp, wsDisp;
    
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
        userDisp.setText(" ");
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
        wsDisp.setText(" ");
        c.add(wsDisp);
        
        setVisible(true);
    }
    
   
    public void actionPerformed(ActionEvent e){
    }
}
