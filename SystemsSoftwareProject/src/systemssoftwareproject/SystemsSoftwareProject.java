package systemssoftwareproject;

// import java.io.*;
import java.util.*; 

public class SystemsSoftwareProject {

    public static void main(String[] args) {
        boolean valid_option_chosen = false;
        while (!valid_option_chosen){
            System.out.println("Main Menu");
            Scanner sc= new Scanner(System.in); // System.in is a standard input stream  
            System.out.print("Do you want to login or signup? ");   
            String message = sc.nextLine();  // reads string
            if("login".equals(message)){
                System.out.println("U chose login");
            }
            else if("signup".equals(message)){
                System.out.println("U chose signup");
            }
            else {
               System.out.println("That is not an option"); 
            }
        }

    }
}
