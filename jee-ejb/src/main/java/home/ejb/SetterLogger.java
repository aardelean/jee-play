package home.ejb;

import home.api.UsernameEvent;
import home.api.interceptors.Log;
import home.api.qualifiers.SetUsernameEvent;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by alex on 6/27/2015.
 */
@Stateless
public class SetterLogger {

    @Resource(mappedName="java:/LocalFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName="java:/jms/queue/UsersLogin")
    private Queue queue;

    @PostConstruct
    public void initializeConnection(){

    }

    @Log
    public void logUsername(@Observes @SetUsernameEvent UsernameEvent username){
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            Message message = session.createTextMessage(username.getValue());
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
