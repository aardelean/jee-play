package home.jsf;

import home.api.User;
import home.api.qualifiers.Dummy;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by alex on 6/27/2015.
 */
@Dependent
@Dummy
public class DummyUserBean implements User, Serializable{

    @Override
    public void setUsername(String username) {

    }

    @Override
    public String getUsername() {
        return "dummy";
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return null;
    }
}
