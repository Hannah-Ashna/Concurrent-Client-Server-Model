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
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import systemssoftwareproject.DataStructures.WSSTYPE;
import systemssoftwareproject.DataStructures.WeatherStationType;
import systemssoftwareproject.DataStructures.usercom;

/**
 *
 * @author Nicholas McCaig
 */
public class User {
    private WSSTYPE wss;
    private ObjectInputStream inFromStation;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("User!\n");
        User user = new User();
        user.run();
    }
    public void run() throws IOException, ClassNotFoundException, InterruptedException {

        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 1233);
        
        //var scanner = new Scanner(System.in);
        inFromStation = new ObjectInputStream(socket.getInputStream());
        var outToStation = new PrintWriter(socket.getOutputStream(), true);
        outToStation.println(usercom.REQUESTSTATIONS);
        while(true){
        int type  = inFromStation.readInt();
            if(type == usercom.WSSTYPE){
                wss = (WSSTYPE)inFromStation.readObject();
                Iterator<WeatherStationType> it = wss.weatherStations.iterator();
                while(it.hasNext()){
                    System.out.println(it.next().toString());

                }
                TimeUnit.SECONDS.sleep(10);// replace with constant


            }
        }
    }
}
