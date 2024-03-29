/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.User;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicholas McCaig
 */
public class DataUpdater implements Runnable{
    private final User user;
    DataUpdater(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.SECONDS.sleep(5);
                if("None".equals(user.currentWSID)){
                } else {
                    user.requestStation(user.currentWSID);
                }
                TimeUnit.SECONDS.sleep(5);
                user.requestStationIDList();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
