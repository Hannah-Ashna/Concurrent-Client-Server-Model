package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SignupForm extends JFrame implements ActionListener {
    
    // GUI Components & Variables
    private Container c;
    private final JLabel title;
    private final JLabel user;
    private final JTextField userInp;
    private final JLabel userChk;
    private final JTextField userChkInp;
    private final JLabel pass;
    private final JPasswordField passInp;
    private final JButton create;
    private final JButton back;
    
    private LoginForm loginForm;
    
    String signup_username = "";
    String signup_password = "";
    
    
    public SignupForm() {
        // Setup a basic GUI template for the Sign-up Form GUI
        // This is updated using the other functions
        setTitle("Create Account");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        title = new JLabel("User - Create Account");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(400, 30);
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
        userInp.setLocation(210, 80); 
        c.add(userInp); 
        
        userChk = new JLabel("Re-enter Username"); 
        userChk.setFont(new Font("Arial", Font.PLAIN, 20)); 
        userChk.setSize(200, 20); 
        userChk.setLocation(25, 130); 
        c.add(userChk); 
  
        userChkInp = new JTextField(); 
        userChkInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userChkInp.setSize(190, 20); 
        userChkInp.setLocation(210, 130); 
        c.add(userChkInp); 
        
        pass = new JLabel("Password"); 
        pass.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pass.setSize(100, 20); 
        pass.setLocation(25, 180); 
        c.add(pass); 
  
        passInp = new JPasswordField(); 
        passInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        passInp.setSize(190, 20); 
        passInp.setLocation(210, 180); 
        c.add(passInp); 
        
        create = new JButton("Create"); 
        create.setFont(new Font("Arial", Font.PLAIN, 15)); 
        create.setSize(100, 20); 
        create.setLocation(25, 300); 
        create.addActionListener(this); 
        c.add(create);
        
        back = new JButton("back"); 
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(100, 20); 
        back.setLocation(440, 30); 
        back.addActionListener(this); 
        c.add(back); 
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        // Store data and send user back to the login page
        // Check if credentials are valid
        if (e.getSource() == create){
            String username_input = userInp.getText();
            String password_input = passInp.getText();
            String check_username_input = userChkInp.getText();
            
            boolean status = systemssoftwareproject.Authentication.signup.signup(username_input, check_username_input, password_input);
            
            // If account creation successful - return to Login Form
            if (status){
                loginForm.setVisible(true);
                this.dispose();
            }
            
            // Else - display error
            else{
                JOptionPane.showMessageDialog(c, "Oops, something doesn't seem right? Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (e.getSource() == back){
            // For when the user wants to go back to the login form
           setVisible(false);
           loginForm.setVisible(true);
        }
    }
    
    public void getLoginInstance(LoginForm login){
        // Store the instance of the Login Form to make it visible again
        // when a user's sign up is successful
        loginForm = login;
    }
}