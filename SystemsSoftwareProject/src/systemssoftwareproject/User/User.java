/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import systemssoftwareproject.DataStructures.WSSTYPE;
import systemssoftwareproject.DataStructures.usercom;
import systemssoftwareproject.DataStructures.wscom;
import systemssoftwareproject.WeatherStation.WeatherStation;

/**
 *
 * @author Nicholas McCaig
 */
public class User {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("User!\n");
        User user = new User();
        user.run();
    }
    public void run() throws IOException, ClassNotFoundException {

        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 1233);
        
        //var scanner = new Scanner(System.in);
        ObjectInputStream inFromStation = new ObjectInputStream(socket.getInputStream());
        var outToStation = new PrintWriter(socket.getOutputStream(), true);
        outToStation.println(usercom.REQUESTSTATIONS);
        while(true){
        int type  = inFromStation.readInt();
            if(type == usercom.WSSTYPE){
                WSSTYPE weatherstations = (WSSTYPE)inFromStation.readObject();
                
            }
        }
    }

    private void RecieveRequest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
