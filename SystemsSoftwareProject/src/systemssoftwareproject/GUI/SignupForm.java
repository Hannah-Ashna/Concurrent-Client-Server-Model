package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SignupForm extends JFrame implements ActionListener {
    
    // Components
    private Container c;
    private JLabel title;
    private JLabel user;
    private JTextField userInp;
    private JLabel userChk;
    private JTextField userChkInp;
    private JLabel pass;
    private JTextField passInp;
    private JButton create;
    
    String signup_username = "";
    String signup_password = "";
    
    
    public SignupForm() {
        setTitle("Create Account");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Create a new account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
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
  
        passInp = new JTextField(); 
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
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        // Store data and send user back to the login page
        // Check if credentials are valid
        if (e.getSource() == create){
            String username_input = userInp.getText();
            String password_input = passInp.getText();
            String check_username_input = userChkInp.getText();
            
            systemssoftwareproject.Authentication.signup.signup(
                    username_input, check_username_input, password_input);
            
            this.dispose();
            new LoginForm().setVisible(true);
        }
    }
}