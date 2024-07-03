import Logger.Logger;
import MethodChaining.Human;

public class Main {
    public static void main(String[] args) {
        Logger.GlobalLogLevelTester(Logger.Level.DEBUG);
        Human hman = new Human().setBirthday("2001.01.03").setName("Josh").setGender("LG Microwave");
        System.out.println(hman.getName());
        System.out.println(hman.getBirthday());
        System.out.println(hman.getGender());
    }
}
