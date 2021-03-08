package systemssoftwareproject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginForm extends JFrame implements ActionListener {
    
    // Components
    private Container c;
    private JLabel title;
    private JLabel user;
    private JTextField userInp;
    private JLabel pass;
    private JTextField passInp;
    private JButton login_var;
    private JButton signup;
    
    String login_username = "";
    String login_password = "";
    
    public LoginForm() {
        setTitle("User Client");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("User Client");
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
        userInp.setLocation(150, 80); 
        c.add(userInp); 
  
        pass = new JLabel("Password"); 
        pass.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pass.setSize(100, 20); 
        pass.setLocation(25, 130); 
        c.add(pass); 
  
        passInp = new JTextField(); 
        passInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
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
        // Run login authentication
        if (e.getSource() == login_var){
            String username_input = userInp.getText();
            String password_input = passInp.getText();
            systemssoftwareproject.Authentication.login.login(username_input,
                    password_input);
        }
        
        // Send user to SignupForm
        if (e.getSource() == signup){
           this.dispose();
           new SignupForm().setVisible(true);
        }
    }
}
