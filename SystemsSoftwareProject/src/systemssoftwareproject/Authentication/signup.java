/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Authentication;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Jamie
 */
public class signup {
    public static void signup() {
        boolean valid_signup_details = false;
        while (!valid_signup_details){
            System.out.print("Are you sure you would like to signup? "
                    + "(Enter N to exit)");
            Scanner sc= new Scanner(System.in);
            String exit_status = sc.nextLine();
            if (exit_status.equals("N")){
                break;
            } 
            System.out.print("Username: ");   
            String username = sc.nextLine();
            System.out.print("Confirm username: ");   
            String check_username = sc.nextLine();
            System.out.print("Password: "); 
            String password = sc.nextLine();

            if (username.equals(check_username)){
                System.out.println("Usernames are equal");
                boolean valid_password = security_encryption.password_validation(password);
                System.out.println("VALID? " + valid_password);
                if (valid_password){
                    String hashed_username = security_encryption.encryption(username);
                    String hashed_password = security_encryption.encryption(password);
                    write_account_details(hashed_username, hashed_password);
                    valid_signup_details = true;
                }
                /* At some point we can run some checks on the password.
                I.e. does the password contain at least 1 alpha/num character.
                */
            }
            else{
                System.out.println("Usernames are not equal");
            }
        }
    }
    
    public static void write_account_details(String username,
            String password){
        System.out.println("Writing account details");
        // Stub definition (This function will write details to a text file.
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
