package com.cheng.springbatch.fixed;

import java.io.Serializable;

/**
 * @author chengchenrui
 * @version Id: Student.java, v 0.1 2017.2.28 13:52 chengchenrui Exp $$
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
