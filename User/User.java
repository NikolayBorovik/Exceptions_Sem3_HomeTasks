package Exceptions_Sem3_HomeTasks.User;

public abstract class User {
    private String firstName;
    private String lastName;
    private String patronimic;
    private String birthdate;
    private int phoneNum;
    private String sex;

    public User(String firstName, String lastName, String patronimic, String birthdate, int phoneNum, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronimic = patronimic;
        this.birthdate = birthdate;
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
        return patronimic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getSex() {
        return sex;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronimic(String patronimic) {
        patronimic = patronimic;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
