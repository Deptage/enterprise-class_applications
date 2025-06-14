package lab.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@JMSDestinationDefinition(name = "java:app/jms/NewsQueue",
        interfaceName = "jakarta.jms.Queue", resourceAdapter = "jmsra",
        destinationName = "NewsQueue")
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName =
                "destinationLookup", propertyValue = "java:app/jms/NewsQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "jakarta.jms.Queue")
})
public class NewsMDB implements jakarta.jms.MessageListener {
    @PersistenceContext
    private EntityManager em;
    public NewsMDB() {}

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                NewsItem e = new NewsItem();
                String[] texts = msg.getText().split("\\|",2);
                String heading = texts[0];
                String body = texts[1];
                e.setHeading(heading);
                e.setBody(body);
                em.persist(e);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }



}
