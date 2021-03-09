package systemssoftwareproject.Authentication;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class signup {
    public static boolean signup(String username, String check_username, String password){
        
        if (username.equals(check_username)){
            System.out.println("Usernames are equal");
            boolean valid_password = security_encryption.password_validation(password);
            System.out.println("VALID? " + valid_password);
            if (valid_password){
                String hashed_username = security_encryption.encryption(username);
                String hashed_password = security_encryption.encryption(password);
                write_account_details(hashed_username, hashed_password);
            }
            
            return valid_password;
        }
        
        else{
            System.out.println("Usernames are not equal");
            return false;
        }
    }
    
    public static void write_account_details(String username,String password){
        System.out.println("Writing account details");
        // now create the filestream and connect PrintWriter
        try {
            FileWriter fout = new FileWriter("Account_details",true);
            PrintWriter pout = new PrintWriter(fout,true);
            //write to the file
            pout.println(username + ", " + password);
            pout.close(); // close the stream
        } catch (IOException e) {
            System.err.println("Error! - " + e.getMessage());
        }
    }
}
