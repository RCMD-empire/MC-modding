import Logger.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Logger log = new Logger("Test");
        System.out.println(log.Output("asd"));
    }
}
