package systemssoftwareproject.DataStructures;

import java.io.Serializable;

public class UserType extends ClientType implements Serializable {
    public UserType(){
    }
    
    @Override
    public String toString(){
        return "User{ID= " + ID + "}";
    }
    
}
