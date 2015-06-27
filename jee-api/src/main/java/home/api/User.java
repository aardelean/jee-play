package home.api;

import javax.ejb.Local;

/**
 * Created by alex on 6/27/2015.
 */
@Local
public interface User {

    void setUsername(String username);

    String getUsername();

    void setPassword(String password);

    String getPassword();
}
