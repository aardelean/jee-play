package home.ejb;

import home.api.User;
import home.api.UsernameEvent;
import home.api.interceptors.Log;
import home.api.qualifiers.Random;
import home.api.qualifiers.SetUsernameEvent;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.*;

/**
 * Created by alex on 6/27/2015.
 */
@Stateful
public class UserBean implements User{

    private String username;

    private String password;

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @Log
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
