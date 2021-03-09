package systemssoftwareproject.Server;
import java.net.Socket;
import java.io.*; 


public class ClientHandler implements Runnable { 
    private final Socket clientSocket; 
  
    // Constructor 
    public ClientHandler(Socket socket){ 
        this.clientSocket = socket; 
    } 

    @Override
    public void run(){ 
        try {    
            while(true){
                // Create IO Streams
                DataInputStream fromClient = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(clientSocket.getOutputStream());   
                
                try {
                    String text = fromClient.readUTF();
                    toClient.writeUTF(text.toUpperCase());
                    System.out.println("Success: IT WORKED");
                    //clientSocket.close();                 
                }
                
                catch (IOException e){
                    System.out.println("Error: Nothing from User");
                }

            }
        } 

        catch (IOException e) { 
             System.out.println("ahhh");
        } 
    } 
} 
