 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Authentication;

import java.util.Scanner;

public class Client {
    public static boolean main_menu() {
        boolean login_successful = false;
        while (!login_successful){
            System.out.println("Main Menu");
            boolean valid_option_chosen = false;
            while (!valid_option_chosen){
                Scanner sc= new Scanner(System.in);
                System.out.print("Do you want to login or signup? ");   
                String menu_choice = sc.nextLine();  // reads string
                if(menu_choice.equals("login")){
                    valid_option_chosen = true;
                    login_successful = login.login();
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
        return login_successful;
    }
}
