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
    private JLabel pass;
    private JTextField passInp;
    private JButton create;
    
    public SignupForm() {
        setTitle("Create Account");
        setBounds(300, 90, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Create a new account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(25, 20);
        c.add(title);
        
        user= new JLabel("New Username"); 
        user.setFont(new Font("Arial", Font.PLAIN, 20)); 
        user.setSize(100, 20); 
        user.setLocation(25, 80); 
        c.add(user); 
  
        userInp = new JTextField(); 
        userInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        userInp.setSize(190, 20);
        userInp.setLocation(150, 80); 
        c.add(userInp); 
  
        pass = new JLabel("New Password"); 
        pass.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pass.setSize(100, 20); 
        pass.setLocation(25, 130); 
        c.add(pass); 
  
        passInp = new JTextField(); 
        passInp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        passInp.setSize(190, 20); 
        passInp.setLocation(150, 130); 
        c.add(passInp); 
        
        create = new JButton("Create"); 
        create.setFont(new Font("Arial", Font.PLAIN, 15)); 
        create.setSize(100, 20); 
        create.setLocation(70, 200); 
        create.addActionListener(this); 
        c.add(create); 
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == create){
            this.dispose();
            new LoginForm().setVisible(true);
        }
    }
}