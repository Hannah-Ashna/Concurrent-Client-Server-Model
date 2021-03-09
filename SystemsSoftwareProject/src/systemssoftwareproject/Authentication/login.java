package systemssoftwareproject.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class login {
    public static boolean login(String login_username, String login_password) {
        boolean logged_in = read_account_details(login_username, login_password);
        return logged_in;     
    }
    
    public static boolean read_account_details(String username_entered,
            String password_entered){
        
        String hashed_username_entered = security_encryption.encryption(username_entered);
        String hashed_password_entered = security_encryption.encryption(password_entered);
        
        String file_name = "Account_details";
        try {
            FileReader fin = new FileReader(file_name);
            BufferedReader din = new BufferedReader(fin);
            //read from the file
            String line = null; // line of text

            while ((line = din.readLine()) != null) {
                // here we have read in a line of text
                // now parse line to extract data and print it out to the screen
                StringTokenizer st = new StringTokenizer(line, ",");
                
                String username_found = (st.nextToken().trim());
                String password_found = (st.nextToken().trim());
                
                if (username_found.equals(hashed_username_entered) &&
                    (password_found.equals(hashed_password_entered))){
                        System.out.println("Account Match");
                        return true;
                }
            }
            din.close(); // close the stream
        } catch (IOException e) {
            System.err.println("Error! - " + e.getMessage());
        }
        return false;
    }
}
