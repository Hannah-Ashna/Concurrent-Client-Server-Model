/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.User;
import java.io.*; 
import java.net.*; 
import java.util.*; 
/**
 *
 * @author Nicholas McCaig
 */
public class Main {
    public static void main(String[] args) 
    { 
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
  
            try ( // object of scanner class
                    Scanner sc = new Scanner(System.in)) {
                String line = null;
                while (!"exit".equalsIgnoreCase(line)) {
                    // reading from user
                    line = sc.nextLine();
                    
                    // sending the user input to server
                    out.println(line);
                    out.flush();
                    
                    // displaying server reply
                    System.out.println("Server replied "
                            + in.readLine());
                }
                // closing the scanner object
            } 
        } 
        catch (IOException e) { 
        } 
    } 
}
