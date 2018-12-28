package ua.melnyk.training.beans.loggers;

import ua.melnyk.training.beans.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
