package systemssoftwareproject.DataStructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserType extends ClientType implements Serializable {
    public UserType(){
    }
    
    public String username = "username is being Configured";
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    @Override
    public String toString(){
        return "###";
    }
    
}
