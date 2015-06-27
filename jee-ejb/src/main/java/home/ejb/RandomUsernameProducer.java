package home.ejb;

import home.api.StringProducer;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * Created by alex on 6/27/2015.
 */
@Stateless
public class RandomUsernameProducer implements StringProducer{

    private Random random = new Random();

    @Override
    @Produces
    @home.api.qualifiers.Random
    public String newString() {
        return Double.toString(random.nextGaussian());
    }
}
