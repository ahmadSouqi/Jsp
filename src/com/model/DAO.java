package com.model;

/**
 * Created by asouqi on 3/15/18.
 */
public class DAO implements CRUDOperation{
    private String url;
    private String userName;
    private String passWord;

    public DAO(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

}
