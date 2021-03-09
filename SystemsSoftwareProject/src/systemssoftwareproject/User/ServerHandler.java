package systemssoftwareproject.User;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
            System.out.println("Test");
            // establish a connection by providing host and port 
            // number 
            try (Socket socket = new Socket("localhost", 1234)) { 
                while(true){
                    // Create IO Streams
                    DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                    DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                    
                    if (UserClient.inputData() != null){
                        System.out.println("Sending server message:");
                        toServer.writeUTF(UserClient.inputData());

                        
                        String text = fromServer.readUTF();
                        System.out.println("Received server message:");
                        System.out.println(text);
                        UserClient.resetData();                        
                    }

                }


            } 
            catch (IOException e) { 
            }
        }
    } 
}
