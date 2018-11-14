package ua.training.model;

public class Record {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String comment;
    private String phoneNumber;
    private String email;
    private String date;
    private Group group;

    public Record() {
    }

    public Record(String firstName, String lastName, String login,
                  String comment, String phoneNumber, String email,
                  String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.comment = comment;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
    }

    public Record(int id,
                  String firstName, String lastName, String nickname,
                  String comment, String phoneNumber, String email,
                  String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = nickname;
        this.comment = comment;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getComment() {
        return comment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public Group getGroup() {
        return group;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", comment='" + comment + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", group=" + group +
                '}';
    }
}
