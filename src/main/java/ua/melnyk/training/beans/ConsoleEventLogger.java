package ua.melnyk.training.beans;

public class ConsoleEventLogger implements EventLogger{

    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
