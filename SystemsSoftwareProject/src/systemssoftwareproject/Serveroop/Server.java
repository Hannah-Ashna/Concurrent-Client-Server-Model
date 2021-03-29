package systemssoftwareproject.Serveroop;
import java.io.*; 
import java.net.*; 

        
public class Server extends ServerFunctions  {
       protected UserConnection usert;
       protected wsConnection wst;
     public ServerSocket ws = null; 
     public ServerSocket user = null;
   public static void main(String[] args) 
    { 
        Server server = new Server();
        server.start();
    }


    public void start(){
               
        try { 
  
            // server is listening on port 1234 
            user = new ServerSocket(1233);
            ws = new ServerSocket(1234); 
            // running infinite loop for getting 
            // client request 
                    usert = new UserConnection(this);
                    new Thread((Runnable) usert).start();
                    
                    wst = new wsConnection(this);
                    new Thread((Runnable) wst).start();
            
        } 
        catch (IOException e) { 
        } 
        finally { 
           
            } 
        }
    }
 

