package home.ejb;

import home.api.UsernameEvent;
import home.api.interceptors.Log;
import home.api.qualifiers.SetUsernameEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 * Created by alex on 6/27/2015.
 */
@Stateless
public class SetterLogger {

    @Log
    public void logUsername(@Observes @SetUsernameEvent UsernameEvent username){
        System.out.println("EVENT CAUGHT "+ username.getValue());
    }
}
