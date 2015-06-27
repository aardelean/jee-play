package home.api;

import javax.ejb.Local;

/**
 * Created by alex on 6/27/2015.
 */
@Local
public interface StringProducer {
    String newString();
}
