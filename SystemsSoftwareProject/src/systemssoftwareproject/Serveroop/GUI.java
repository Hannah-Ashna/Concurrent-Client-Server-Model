package systemssoftwareproject.Serveroop;

import java.util.Scanner;

public class GUI implements Runnable {
    private boolean exit = false;
    private Server server;
    
    @Override
    public void run() {
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Command: ");
            String command = userInput.nextLine().toUpperCase();
            if(command.startsWith("Currently Active WS Count:")){
                System.out.println(server.wsCount());
            }
        }
        
    }
    public GUI(Server server){
        this.server = server;
        
    }
    
}
