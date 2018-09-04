package com.matthew.model;

public class User {
    private String mUserName;
    private String mPassword;

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public User(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }
}
