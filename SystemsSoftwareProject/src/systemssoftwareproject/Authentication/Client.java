 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Client {
    public static void main_menu() {
        while (true){
            System.out.println("Main Menu");
            boolean valid_option_chosen = false;
            while (!valid_option_chosen){
                Scanner sc= new Scanner(System.in);
                System.out.print("Do you want to login or signup? ");   
                String menu_choice = sc.nextLine();  // reads string
                if(menu_choice.equals("login")){
                    valid_option_chosen = true;
                    login();
                }
                else if(menu_choice.equals("signup")){
                    valid_option_chosen = true;
                    signup.signup();
                }
                else {
                   System.out.println("That is not a valid option"); 
                }
            } 
        }
    }
   
    
    public static void login() {
        boolean logged_in = false;
        while (!logged_in){
            System.out.print("Are you sure you would like to signup? "
                    + "(Enter N to exit)");
            Scanner sc= new Scanner(System.in);
            String exit_status = sc.nextLine();
            if (exit_status.equals("N")){
                break;
            } 
            System.out.print("Username: ");   
            String login_username = sc.nextLine();
            System.out.print("Password: "); 
            String login_password = sc.nextLine();
            logged_in = read_account_details(login_username, login_password);
        }
        System.out.println("Account authenticated");
        // Connect the user to the server
    }
    
    public static boolean read_account_details(String username_entered,
            String password_entered){
        
        String hashed_username_entered = signup.encryption(username_entered);
        String hashed_password_entered = signup.encryption(password_entered);
        
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
