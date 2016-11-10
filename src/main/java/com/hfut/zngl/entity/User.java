package com.hfut.zngl.entity;

/**
 * Created by 东东 on 2016/11/8.
 */

public class User {

    private int userID;
    private String userName;
    private String pwd;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
