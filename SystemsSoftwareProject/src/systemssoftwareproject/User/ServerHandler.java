package systemssoftwareproject.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import systemssoftwareproject.GUI.LoginForm;
import systemssoftwareproject.GUI.UserClient;

public class ServerHandler {
    public static void main(String[] args){ 
        LoginForm loginForm = new LoginForm();
        
        if (true){
            // establish a connection by providing host and port 
            // number 
            try (Socket socket = new Socket("localhost", 1234)) { 

                // writing to server 
                PrintWriter out = new PrintWriter( 
                    socket.getOutputStream(), true); 

                // reading from server 
                BufferedReader in 
                    = new BufferedReader(new InputStreamReader( 
                        socket.getInputStream())); 
                
                // object of scanner class
                //try (Scanner sc = new Scanner(System.in)) {
                    //String line = null;
                   // while (!"exit".equalsIgnoreCase(line)) {
                        // reading from user
                        //line = sc.nextLine();

                        // sending the user input to server
                        out.println(UserClient.inputData());
                        

                        // displaying server reply
                        System.out.println("Server replied " + in.readLine());
                    //}
                    // closing the scanner object
               // } 
            } 
            catch (IOException e) { 
            }
        }
    } 
}
