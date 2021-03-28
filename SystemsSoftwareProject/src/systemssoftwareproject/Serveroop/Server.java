package systemssoftwareproject.Serveroop;
import java.io.*; 
import java.net.*; 

        
public class Server extends ServerFunctions  {
   public static void main(String[] args) 
    { 
        Server server = new Server();
        server.start();
    }


    public void start(){
                ServerSocket ws = null; 
                ServerSocket user = null;
        try { 
  
            // server is listening on port 1234 
            ws = new ServerSocket(1234); 
            ws.setReuseAddress(true);
            user = new ServerSocket(1233);
            user.setReuseAddress(true);

  
            // running infinite loop for getting 
            // client request 
            while (true) { 
  
                // socket object to receive incoming client 
                // requests 
                Socket wsclient = ws.accept(); 
  
                // Displaying that new client is connected 
                // to server 
                System.out.println("New weatherStation connected "
                                   + wsclient.getInetAddress() 
                                         .getHostAddress()); 
  
                // create a new thread object 
                ClientHandler clientSock 
                    = new ClientHandler(wsclient, this); 
  
                // This thread will handle the client 
                // separately 
                new Thread((Runnable) clientSock).start(); 
                
                Socket userclient = user.accept(); 
  
                // Displaying that new client is connected 
                // to server 
                System.out.println("New user connected "
                                   + userclient.getInetAddress() 
                                         .getHostAddress()); 
  
                // create a new thread object 
                UserHandler userSock 
                    = new UserHandler(userclient, this); 
  
                // This thread will handle the client 
                // separately 
                new Thread((Runnable) userSock).start(); 
            }
        } 
        catch (IOException e) { 
        } 
        finally { 
            if (ws != null ) { 
                try { 
                    ws.close(); 
                    
                } 
                catch (IOException e) { 
                } 
            }else if(user != null){
                try { 
                    user.close(); 
                    
                } 
                catch (IOException e) { 
                }
            } 
        }
    }
}
