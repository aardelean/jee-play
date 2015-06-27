package home.ejb;

import home.api.User;
import home.api.interceptors.Log;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * Created by alex on 6/27/2015.
 */
@MessageDriven(mappedName="java:/jms/queue/UsersLogin", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/UsersLogin"),
        @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "java:/LocalFactory"),
})
public class UsernameListener implements MessageListener {

    @EJB
    private User user;

    @Override
    @Log
    public void onMessage(Message message) {
        try {
            String stringProperty = ((TextMessage)message).getText();
            System.out.println("async event caught: " + stringProperty);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
