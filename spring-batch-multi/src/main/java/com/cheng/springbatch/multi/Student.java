/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.springbatch.multi;

import java.io.Serializable;

/**
 * @author chengchenrui
 * @version Id: Student.java, v 0.1 2017.3.3 15:31 chengchenrui Exp $$
 */
public class Student implements Serializable {
    /**
     * ID
     */
    private String ID    = "";
    /**
     * 名字
     */
    private String name  = "";
    /**
     * 年龄
     */
    private int    age   = 0;
    /**
     * 分数
     */
    private float  score = 0;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
