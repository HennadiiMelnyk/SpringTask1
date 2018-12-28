package ua.melnyk.training.loggers;


import ua.melnyk.training.beans.Event;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
