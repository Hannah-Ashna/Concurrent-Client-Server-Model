package systemssoftwareproject;

// import java.io.*;
import java.util.*; 

public class SystemsSoftwareProject {
    
    public static void main(String[] args) {
        System.out.println("Main Menu");
        boolean valid_option_chosen = false;
        while (!valid_option_chosen){
            Scanner sc= new Scanner(System.in); // System.in is a standard input stream  
            System.out.print("Do you want to login or signup? ");   
            String menu_choice = sc.nextLine();  // reads string
            if(menu_choice.equals("login")){
                System.out.println("U chose login");
            }
            else if(menu_choice.equals("signup")){
                System.out.println("U chose signup");
                signup();
            }
            else {
               System.out.println("That is not an option"); 
            }
        }
    }
    
    public static void signup() {
        boolean valid_signup_details = true;
        while (valid_signup_details){
            Scanner sc= new Scanner(System.in); 
            System.out.print("Username: ");   
            String username = sc.nextLine();
            System.out.print("Confirm username: ");   
            String check_username = sc.nextLine();
            System.out.print("Password: "); 
            String password = sc.nextLine();

            if (username.equals(check_username)){
                System.out.println("Usernames are equal");
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
}
