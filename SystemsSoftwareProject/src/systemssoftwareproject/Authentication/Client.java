 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Nicholas McCaig
 */
public class Client {
    public static void main_menu() {
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
                signup();
            }
            else {
               System.out.println("That is not a valid option"); 
            }
        }
    }
    
    public static void signup() {
        boolean valid_signup_details = false;
        while (!valid_signup_details){
            Scanner sc= new Scanner(System.in); 
            System.out.print("Username: ");   
            String username = sc.nextLine();
            System.out.print("Confirm username: ");   
            String check_username = sc.nextLine();
            System.out.print("Password: "); 
            String password = sc.nextLine();

            if (username.equals(check_username)){
                System.out.println("Usernames are equal");
                validation(password);
                valid_signup_details = true;
                write_account_details(username, password);
                /* At some point we can run some checks on the password.
                I.e. does the password contain at least 1 alpha/num character.
                */
            }
            else{
                System.out.println("Usernames are not equal");
                valid_signup_details = false;
            }
        }
    }
    
    public static boolean validation(String password_entered){
        System.out.println("Validating");
        char[] chars = password_entered.toCharArray();
        boolean contains_digit = false;
        for(char c : chars){
            if(Character.isDigit(c)){
                contains_digit = true;
                break;
            }
        }
        System.out.println(contains_digit);
        return contains_digit;
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
    
    public static void login() {
        boolean logged_in = false;
        while (!logged_in){
            Scanner sc= new Scanner(System.in); 
            System.out.print("Username: ");   
            String login_username = sc.nextLine();
            System.out.print("Password: "); 
            String login_password = sc.nextLine();
            logged_in = read_account_details(login_username, login_password);
        }
        System.out.println("Account authenticated");
        // Connect the user to the server
    }
    
    public static boolean read_account_details(String username,
            String password){
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
                
                if (username_found.equals(username) &&
                        (password_found.equals(password))){
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
