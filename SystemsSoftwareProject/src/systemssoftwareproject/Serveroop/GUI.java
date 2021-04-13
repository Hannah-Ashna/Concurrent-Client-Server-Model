package systemssoftwareproject.Serveroop;
import systemssoftwareproject.GUI.ServerGUI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI implements Runnable {
    private boolean exit = false;
    private Server server;
    private int wsTotal = 0;
    private int userTotal = 0;
    
    @Override
    public void run() {
        Scanner userInput = new Scanner(System.in);
        ServerGUI serverGUI = new ServerGUI();
        while(true){
            if (server.wsCount() != wsTotal || server.userCount() != userTotal){
                try {
                    serverGUI.getClients(server.wsCount(), server.userCount());
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                wsTotal = server.wsCount();
                userTotal = server.userCount();
            }
        }   
    }
    
    public GUI(Server server){
        this.server = server;
    }
    
}
