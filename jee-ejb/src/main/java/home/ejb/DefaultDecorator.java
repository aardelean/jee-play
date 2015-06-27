package home.ejb;

import com.sun.mail.smtp.DigestMD5;
import home.api.User;
import home.api.UsernameEvent;
import home.api.qualifiers.SetUsernameEvent;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alex on 6/27/2015.
 */
@Decorator
public class DefaultDecorator implements User{

    @Delegate @Inject @Any
    private User user;

    @Inject
    @SetUsernameEvent
    private Event<UsernameEvent> usernameEvent;

    @Override
    public void setUsername(String username) {
        user.setUsername(username);
        usernameEvent.fire(new UsernameEvent(username));
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void setPassword(String password) {
        try {
            user.setPassword(new String(MessageDigest.getInstance("MD5").digest(password.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
}
