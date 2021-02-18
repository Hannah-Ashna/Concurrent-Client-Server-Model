package systemssoftwareproject.Server;
import java.io.*; 
import java.net.*; 
public class Main {
   public static void main(String[] args) 
    { 
        ServerSocket server = null; 
  
        try { 
  
            // server is listening on port 1234 
            server = new ServerSocket(1234); 
            server.setReuseAddress(true); 
  
            // running infinite loop for getting 
            // client request 
            while (true) { 
  
                // socket object to receive incoming client 
                // requests 
                Socket client = server.accept(); 
  
                // Displaying that new client is connected 
                // to server 
                System.out.println("New client connected"
                                   + client.getInetAddress() 
                                         .getHostAddress()); 
  
                // create a new thread object 
                ClientHandler clientSock 
                    = new ClientHandler(client); 
  
                // This thread will handle the client 
                // separately 
                new Thread((Runnable) clientSock).start(); 
            } 
        } 
        catch (IOException e) { 
        } 
        finally { 
            if (server != null) { 
                try { 
                    server.close(); 
                } 
                catch (IOException e) { 
                } 
            } 
        } 
    }
}
