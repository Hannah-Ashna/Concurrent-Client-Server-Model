package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class UserClient extends JFrame implements ActionListener {
    
    // Components
    private final Container c;
    private final JLabel title;
    private final JLabel user;
    private final JTextField userInp;
    private final JTextArea display;
    private final JButton send ;

    static String data = null;
    
    public UserClient() {
        setTitle("User Client");
        setBounds(300, 90, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Dashboard:");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(25, 20);
        c.add(title);
        
        user = new JLabel("User Input"); 
        user.setFont(new Font("Arial", Font.PLAIN, 20)); 
        user.setSize(120, 20); 
        user.setLocation(25, 80); 
        c.add(user); 
  
        userInp = new JTextField(); 
        userInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userInp.setSize(190, 40);
        userInp.setLocation(150, 80); 
        c.add(userInp); 
        
        display = new JTextArea();
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setSize(300, 400);
        display.setLocation(350, 80);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setText("Sample");
        c.add(display);
        
        
        send = new JButton("Send"); 
        send.setFont(new Font("Arial", Font.PLAIN, 15)); 
        send.setSize(100, 20); 
        send.setLocation(25, 300); 
        send.addActionListener(this); 
        
        c.add(send); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == send ){
            data = userInp.getText();
            display.setText(data);
        }
    }
    
    public static String inputData(){
        return data;
    }
    
    public static void resetData(){
        data = null;
    }
    
    
}
