package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginForm extends JFrame implements ActionListener {
    
    // GUI Components & Variables
    private final Container c;
    private final JLabel title;
    private final JLabel user;
    private final JTextField userInp;
    private final JLabel pass;
    private final JPasswordField passInp;
    private final JButton login_var;
    private final JButton signup;
    
    boolean status = false;
    String login_username = "";
    String login_password = "";
    
    public LoginForm() {
        // Setup a basic GUI template for the Login Form's GUI
        // This is updated using the other functions
        setTitle("User Client");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        title = new JLabel("User - Login");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(25, 20);
        c.add(title);
        
        user= new JLabel("Username"); 
        user.setFont(new Font("Arial", Font.PLAIN, 20)); 
        user.setSize(100, 20); 
        user.setLocation(25, 80); 
        c.add(user); 
  
        userInp = new JTextField(); 
        userInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userInp.setSize(190, 20);
        userInp.setLocation(150, 80); 
        c.add(userInp); 
  
        pass = new JLabel("Password"); 
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20); 
        pass.setLocation(25, 130); 
        c.add(pass); 
  
        passInp = new JPasswordField(); 
        passInp.setFont(new Font("Arial", Font.PLAIN, 15));
        passInp.setEchoChar('*');
        passInp.setSize(190, 20); 
        passInp.setLocation(150, 130); 
        c.add(passInp); 
        
        login_var = new JButton("Login"); 
        login_var.setFont(new Font("Arial", Font.PLAIN, 15)); 
        login_var.setSize(100, 20); 
        login_var.setLocation(70, 200); 
        login_var.addActionListener(this); 
        c.add(login_var); 
  
        signup = new JButton("Signup"); 
        signup.setFont(new Font("Arial", Font.PLAIN, 15)); 
        signup.setSize(100, 20); 
        signup.setLocation(220, 200); 
        signup.addActionListener(this); 
        c.add(signup); 
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        // Run login authentication process
        if (e.getSource() == login_var){
            String username_input = userInp.getText();
            login_username = username_input;
            
            String password_input = passInp.getText();
            status = systemssoftwareproject.Authentication.login.login(username_input, password_input);
            
            // If credentials are a match - login successfully
            if(status) {
                setVisible(false);
            }
            
            // Else - display error
            else{
                JOptionPane.showMessageDialog(c, "Incorrect Credentials! Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Send user to SignupForm
        if (e.getSource() == signup){
           setVisible(false);
           SignupForm signupForm = new SignupForm();
           signupForm.getLoginInstance(this);
        }
    }
    
    public String getUsername(){
        return login_username;
    }
    
    public boolean returnStatus(){
        // Returns status of whether user is logged in or not
        return status;
    }
}