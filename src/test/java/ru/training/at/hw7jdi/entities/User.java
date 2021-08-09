package ru.training.at.hw7jdi.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    private String username;
    private String password;
    private String fullName;

    public static final User ROMAN_IOVLEV = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
