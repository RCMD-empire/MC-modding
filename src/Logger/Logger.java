package Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[0m";
    public static final String RED = "\u001B[0m";
    enum Level { DEBUG, INFO, WARN, ERROR }
    public String Name;
    public Level level;

    public Logger(String name) {
        Name = name;
    }

    public String Output(String msg) {
        //Get current date time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formatDateTime = now.format(formatter);

        return "["+formatDateTime+"] ["+level+"] ["+Name+"] "+msg;
    }
    
}
