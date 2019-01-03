package ua.melnyk.training.loggers;

import ua.melnyk.training.beans.Event;

import java.io.IOException;

public interface EventLogger {

    public void logEvent(Event event) throws IOException;

}
