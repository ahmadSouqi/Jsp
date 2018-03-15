package com.model;

import java.io.Serializable;

/**
 * Created by asouqi on 3/15/18.
 */
public class User implements Serializable {

    private String UserName;
    private String Password;
    private String roll;

    public User(String userName, String password, String roll) {
        UserName = userName;
        Password = password;
        this.roll = roll;
    }

    public User(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getRoll() {
        return roll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (UserName != null ? !UserName.equals(user.UserName) : user.UserName != null) return false;
        return Password != null ? Password.equals(user.Password) : user.Password == null;
    }

    @Override
    public int hashCode() {
        int result = UserName != null ? UserName.hashCode() : 0;
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        return result;
    }
}
