package systemssoftwareproject;

import systemssoftwareproject.Authentication.Client;

public class SystemsSoftwareProject {
    
    public static void main(String[] args) {
        // Take the user to the login and signup screen
        boolean account_authenticated = Client.main_menu();
        if (account_authenticated){
            // Connect the client to the server
            System.out.println("It's time to connect to the server!");
        }
    }
}
