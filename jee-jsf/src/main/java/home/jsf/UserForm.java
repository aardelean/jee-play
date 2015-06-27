package home.jsf;

import home.api.User;
import home.api.qualifiers.Dummy;
import home.api.qualifiers.Random;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by alex on 6/27/2015.
 */
@Named("userClient")
@ConversationScoped
public class UserForm implements Serializable{

    @Inject
    private User user;

    @Random
    @Inject
    private String randomUsername;


    public void setUsername(String username){
        user.setUsername(username);
    }

    public String getUsername(){
        return user.getUsername();
    }
    public void setPassword(String password){
        user.setPassword(password);
    }
    public String getPassword(){
        return user.getPassword();
    }
}
