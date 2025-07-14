package Homework4;
import java.io.*;
import java.time.Instant;

public class FileLogger implements AutoCloseable{
    File file;

    FileLogger(String file_Path){
        file = new File(file_Path);
    }

    public void log(String str) throws IOException {
        try (FileWriter a = new FileWriter(file.getPath(), true)) {
            Instant timestamp = Instant.now();
            a.write(timestamp + " " + str + System.lineSeparator());
            a.close();
            System.out.println("Row added successfully to " + file.getPath());
        } catch (IOException e) {
            System.err.println("Error adding row to file: " + e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing!");
    }
}
