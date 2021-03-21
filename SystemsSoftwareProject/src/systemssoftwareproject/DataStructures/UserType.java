/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.DataStructures;

import java.io.Serializable;

/**
 *
 * @author Nicholas McCaig
 */
public class UserType extends ClientType implements Serializable {
    public UserType(){
    }
    
    @Override
    public String toString(){
        return "User{ID= " + ID + "}";
    }
    
}
