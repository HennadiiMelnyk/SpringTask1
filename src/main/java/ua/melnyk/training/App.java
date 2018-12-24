package ua.melnyk.training;

import ua.melnyk.training.beans.Client;
import ua.melnyk.training.beans.ConsoleEventLogger;

public class App {

    Client client=new Client();
    ConsoleEventLogger eventLogger=new ConsoleEventLogger();
    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "John");
           app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1 ");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
         eventLogger.logEvent(message);

    }
}