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
            }
            else {
               System.out.println("That is not an option"); 
            }
        }

    }
}
