package ua.melnyk.training.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat df) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.date = date;
        this.dateFormat = df;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", dateFormat=" + dateFormat.format(date) +
                '}';
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
