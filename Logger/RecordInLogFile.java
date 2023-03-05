package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RecordInLogFile implements Logger {

    private String filename;

    public RecordInLogFile(String filename) {
        this.filename = filename + ".txt";
    }

    @Override
    public void saveInFile(String data) {
        try{
            FileWriter writer = new FileWriter(filename, true);
            LocalDateTime eventTime = LocalDateTime.now();
            writer.write(String.format("%s %s \n", eventTime, data));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
