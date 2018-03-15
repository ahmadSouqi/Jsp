package com.model;

import java.io.Serializable;

/**
 * Created by asouqi on 3/15/18.
 */
public class User implements Serializable {

    private String UserName;
    private String Password;
    private String roll;

    public User(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName==null?"":UserName;
    }

    public String getPassword() {
        return Password==null?"":Password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
