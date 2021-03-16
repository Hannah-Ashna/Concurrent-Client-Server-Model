package systemssoftwareproject.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import systemssoftwareproject.GUI.LoginForm;
import systemssoftwareproject.GUI.UserClient;

public class ServerHandler {
    public static void main(String[] args){ 
        LoginForm loginForm = new LoginForm();
        
        if (true){
            // Establish a connection by providing host and port number 
            systemssoftwareproject.Server.Main.set_client_false();
            try (Socket socket = new Socket("localhost", 1234)) { 
                while(true){
                    // Create IO Streams
                    DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                    DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                    
                    if (UserClient.sendData() != null){
                        System.out.println("Sending server message:" +
                                UserClient.sendData());
                        toServer.writeUTF(UserClient.sendData());

                        
                        String text = fromServer.readUTF();
                        System.out.println("Received server message:" + text);
                        UserClient.receivedData(text);
                        
                        UserClient.resetData();                        
                    }
                }
            }
            
            catch (IOException e) { 
            }
        }
    } 
}
