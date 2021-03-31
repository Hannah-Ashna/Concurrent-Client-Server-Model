/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Serveroop;

import java.util.Scanner;

/**
 *
 * @author nickm
 */
public class GUI implements Runnable {
    private boolean exit = false;
    private Server server;
    @Override
    public void run() {
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Command:");
            String command = userInput.nextLine().toUpperCase();
            if(command.startsWith("WSCOUNT")){
                System.out.println(server.wsCount());
            }
        }
        
    }
    public GUI(Server server){
        this.server = server;
        
    }
    
}
