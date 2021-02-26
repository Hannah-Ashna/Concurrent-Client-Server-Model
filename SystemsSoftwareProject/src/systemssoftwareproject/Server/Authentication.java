/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Server;
import systemssoftwareproject.DataStructures.*;
/**
 *
 * @author Nicholas McCaig
 */
interface OnNewUserCreatedEventListner {
    void OnNewUserCreatedEvent();
}
public class Authentication {
        private OnNewUserCreatedEventListner newUserCreationListner;

    /**
     *
     * @param newUserCreationListner
     */
     void registerOnGeekEventListener(OnNewUserCreatedEventListner newUserCreationListner) 
    { 
        this.newUserCreationListner = newUserCreationListner; 
    } 
    public boolean ValidateCredentials(String username, String password ){
        //confirms username and credential are valid
        return false;
    }

    /**
     *
     * @param username
     * @param password
     * @param clientType
     */
     void CreateCredentials(String username, String password, ClientType clientType){
         //creates new user in the database
         new Thread(() -> {
             System.out.println("Createing a new user");
             //I'll now try to add the credentatials to the database!
             if (newUserCreationListner != null) {
                 //I tell the main function that I have completed!
                 newUserCreationListner.OnNewUserCreatedEvent();
                 
             }
         }).start();
    }
    void DeleteCredentials(String username, String password){
        //I will delete a users credentials
    }
     
}