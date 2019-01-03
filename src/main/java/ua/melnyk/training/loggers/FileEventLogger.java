package ua.melnyk.training.loggers;

import ua.melnyk.training.beans.Event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileEventLogger implements EventLogger {

    private File file;

    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        file = new File(filename);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + filename);
        } else if (!file.exists()) {
            file.createNewFile();
        }
    }

    @Override
    public void logEvent(Event event) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        try {

            //writer.write(file,event.toString());
            writer.append(event.toString() + "\n");
            //FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}