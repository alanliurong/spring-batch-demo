/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.springbatch.jdbc;

/**
 * @author chengchenrui
 * @version Id: User.java, v 0.1 2017.3.8 11:45 chengchenrui Exp $$
 */
public class User {

    private String id;
    private String userId;
    private String userName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
