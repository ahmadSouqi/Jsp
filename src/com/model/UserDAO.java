package com.model;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asouqi on 3/15/18.
 */
public class UserDAO {
    private String url;
    private String userName;
    private String passWord;

    public UserDAO(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Set<User> getUsers(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select * from Servlet.Users;");
            Set<User> users=new HashSet<>();

            while (set.next()){
                users.add(new User(set.getString(1),set.getString(2),
                        set.getString(3)));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
