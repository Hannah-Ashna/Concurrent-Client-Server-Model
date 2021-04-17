package systemssoftwareproject.Serveroop;
import java.io.*; 
import java.net.*; 

        
public class Server extends ServerFunctions  {
    protected UserConnection usert;
    protected wsConnection wst;
    public ServerSocket ws = null; 
    public ServerSocket user = null;
    public GUI gui;
    
    public static void main(String[] args) 
    { 
        Server server = new Server();
        server.start();
    }


    public void start(){
        
        
        try { 
  
            // Server is listening 
            user = new ServerSocket(9090);
            ws = new ServerSocket(9091);
            
            // Running infinite loop for getting client requests
            usert = new UserConnection(this);
            new Thread((Runnable) usert).start();
                    
            wst = new wsConnection(this);
            new Thread((Runnable) wst).start();
            
            gui = new GUI(this);
            new Thread((Runnable)gui).start();
            
        }
        
        catch (IOException e) { 
        } 
        
        finally { 
        } 
    }
    
    
  
}
 
