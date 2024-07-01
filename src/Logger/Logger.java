package Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    // not nessesary
    private static final String BLUE = "\u001B[34m";

    public static enum Level { DEBUG, INFO, WARN, ERROR }
    private String Name;
    private static Level GlobalLogLevel;

    public static Level getGlobalLogLevel() {
        return GlobalLogLevel;
    }
    public static void setGlobalLogLevel(Level globalLogLevel) {
        GlobalLogLevel = globalLogLevel;
    }
    // 2 params constructor
    public Logger(String name, Level globalLogLevel) {
        Name = name;
        GlobalLogLevel=globalLogLevel;
    }
    // 1 param constructor
    public Logger(String name) {
        this(name,Level.DEBUG);
    }

    private void Output(Level lvl, String msg) {
        if (GlobalLogLevel.ordinal() <= lvl.ordinal()) {
            String out="";
            // coloring
            switch (lvl)
            {
                case DEBUG:
                    //out = RESET;
                    break;
                case INFO:
                    //out = RESET;
                    break;
                case WARN:
                    out = YELLOW;
                    break;
                case ERROR:
                    out = RED;
                    break;
            }
            //Get current date time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formatDateTime = now.format(formatter);
            // formatting output
            out += "[" + formatDateTime + "][" + lvl + "][" + Name + "] " + msg;

            // reverse coloring
            out += RESET;
            // writing out
            System.out.println(out);
        }
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

    public static void GlobalLogLevelTester(Level lvl){
        Logger log = new Logger("GlobalLogLevelTester");
        Logger.setGlobalLogLevel(lvl);
        log.debug("Debug");
        log.info("info");
        log.warn("warn");
        log.error("Error");
    }
}
