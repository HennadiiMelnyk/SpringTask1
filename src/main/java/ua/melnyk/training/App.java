package ua.melnyk.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.melnyk.training.beans.Client;
import ua.melnyk.training.beans.Event;
import ua.melnyk.training.beans.EventType;
import ua.melnyk.training.loggers.ConsoleEventLogger;
import ua.melnyk.training.loggers.EventLogger;

import java.io.IOException;
import java.util.Map;

public class App {

    private Client client;

    private EventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;

    private String startupMessage;

    public App() {}

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");

        event=ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR,event,"miss");

        ctx.close();

    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }
}
