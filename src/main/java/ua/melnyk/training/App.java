package ua.melnyk.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.melnyk.training.beans.Client;
import ua.melnyk.training.beans.ConsoleEventLogger;

public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        super();
        this.client=client;
        this.eventLogger=consoleEventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app",App.class);

        app.client = new Client("1", "John");
        app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1 ");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);

    }
}
