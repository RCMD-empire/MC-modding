package MethodChaining;

public class Human {
    private String Name;
    private String Birthday;
    private String Gender;

    public String getName() {
        return Name;
    }

    public Human setName(String name) {
        Name = name;
        return this;
    }

    public String getBirthday() {
        return Birthday;
    }

    public Human setBirthday(String birthday) {
        Birthday = birthday;
        return this;
    }

    public String getGender() {
        return Gender;
    }

    public Human setGender(String gender) {
        Gender = gender;
        return this;
    }
}
