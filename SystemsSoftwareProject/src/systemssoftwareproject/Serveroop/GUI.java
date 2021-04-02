package systemssoftwareproject.Serveroop;
import systemssoftwareproject.GUI.ServerGUI;
import java.util.Scanner;


public class GUI implements Runnable {
    private boolean exit = false;
    private Server server;
    
    @Override
    public void run() {
        Scanner userInput = new Scanner(System.in);
        ServerGUI serverGUI = new ServerGUI();
        while(true){
            System.out.println("Command: ");
            String command = userInput.nextLine().toUpperCase();
            if(command.startsWith("WSCOUNT")){
                System.out.println(server.wsCount());
                serverGUI.getWSClients(server.wsCount());
                
            }
        }   
    }
    
    public GUI(Server server){
        this.server = server;
    }
    
}
