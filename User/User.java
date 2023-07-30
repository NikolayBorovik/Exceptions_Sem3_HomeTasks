package Exceptions_Sem3_HomeTasks.User;

public abstract class User {
    private String firstName;
    private String lastName;
    private String Patronimic;
    private String db;
    private int phoneNum;
    private Character sex;

    public User(String firstName, String lastName, String patronimic, String db, int phoneNum, Character sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        Patronimic = patronimic;
        this.db = db;
        this.phoneNum = phoneNum;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronimic() {
        return Patronimic;
    }

    public String getDb() {
        return db;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public Character getSex() {
        return sex;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronimic(String patronimic) {
        Patronimic = patronimic;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
