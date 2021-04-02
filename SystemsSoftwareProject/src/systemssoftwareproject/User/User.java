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
import systemssoftwareproject.GUI.LoginForm;

public class User {
    private WSSTYPE wss;
    private ObjectInputStream inFromStation;
    private PrintWriter outToStation;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("User!");
        LoginForm loginForm = new LoginForm();

        while (loginForm.returnStatus() == false){
            // Waits for user to finish logging in
        }
        if (loginForm.returnStatus()){
            User user = new User();
            user.run();
        }
        
    }
    
    public void run() throws IOException, ClassNotFoundException, InterruptedException {

        // Make connection and initialize streams
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9090);
        
        //var scanner = new Scanner(System.in);
        inFromStation = new ObjectInputStream(socket.getInputStream());
        outToStation = new PrintWriter(socket.getOutputStream(), true);
        outToStation.println(usercom.REQUESTSTATIONS);
        while(true){
            try{
                if(inFromStation.readInt() == 0){
                    System.out.println("Test<3");
                    wss = (WSSTYPE)inFromStation.readObject();
                    System.out.println(wss.wsCount());
                }  
            }catch(IOException e){
            }
        }
    }
}
