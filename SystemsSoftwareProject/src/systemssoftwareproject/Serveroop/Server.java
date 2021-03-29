package systemssoftwareproject.Serveroop;
import java.io.*; 
import java.net.*; 

        
public class Server extends ServerFunctions  {
       private UserConnection usert;
       private wsConnection wst;
     ServerSocket ws = null; 
                ServerSocket user = null;
   public static void main(String[] args) 
    { 
        Server server = new Server();
        server.start();
    }


    public void start(){
               
        try { 
  
            // server is listening on port 1234 
            ws = new ServerSocket(1234); 
            ws.setReuseAddress(true);
            user = new ServerSocket(1233);
            user.setReuseAddress(true);

  
            // running infinite loop for getting 
            // client request 
            while (true) { 
                if(usert == null){
                    usert = new UserConnection(this);
                    usert.run();
                }
                if(wst == null){
                    wst = new wsConnection(this);
                    wst.run();
                }
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
