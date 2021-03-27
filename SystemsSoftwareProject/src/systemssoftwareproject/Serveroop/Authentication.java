package systemssoftwareproject.Serveroop;
import systemssoftwareproject.DataStructures.*;

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
     void CreateCredentials(String username, String password, UserType clientType){
         //creates new user in the database
         new Thread(() -> {
             System.out.println("Creating a new user");
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
