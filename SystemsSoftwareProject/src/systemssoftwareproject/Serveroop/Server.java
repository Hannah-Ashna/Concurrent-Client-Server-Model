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
        ResetIDFile();       
        try { 
  
            // server is listening on port 1234 
            user = new ServerSocket(9090);
            ws = new ServerSocket(9091); 
            // running infinite loop for getting 
            // client requests
                    usert = new UserConnection(this);
                    new Thread((Runnable) usert).start();
                    
                    wst = new wsConnection(this);
                    new Thread((Runnable) wst).start();
                    GUI gui = new GUI(this);
                    new Thread((Runnable)gui).start();
            
        } 
        catch (IOException e) { 
        } 
        finally { 
           
            } 
        }
    
    
    public static void ResetIDFile(){
        try { 
            File fileName = new File("WeatherStationID list.txt");
            fileName.delete();
        } catch (Exception e) {
        } 
    }
    }
 
