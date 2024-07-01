package Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[0m";
    public static final String RED = "\u001B[0m";
    static enum Level { DEBUG, INFO, WARN, ERROR }
    public String Name;

    public Logger(String name) {
        Name = name;
    }

    private void Output(Level lvl, String msg) {
        String out="";
        // coloring
        switch (lvl)
        {
            case DEBUG:
                out = RESET;
                break;
            case INFO:
                out=RESET;
                break;
            case WARN:
                out=YELLOW;
                break;
            case ERROR:
                out=RED;
                break;
        }
//        level.ordinal() <= lvl.ordinal()
        //if(lvl.ordinal())
        //Get current date time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formatDateTime = now.format(formatter);

        out+= "["+formatDateTime+"] ["+lvl+"] ["+Name+"] "+msg;
        out+=RESET;
        System.out.println(out);

    }
    public void debug(String msg) {
        Output(Level.DEBUG,msg);
    }
    public void info(String msg) {
        Output(Level.INFO,msg);
    }
    public void warn(String msg) {
        Output(Level.WARN,msg);
    }
    public void error(String msg) {
        Output(Level.ERROR,msg);
    }
}
