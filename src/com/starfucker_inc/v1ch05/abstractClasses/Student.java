package com.starfucker_inc.v1ch05.abstractClasses;

/**
 * Created by zhangjiyun on 2017/3/8.
 */
public class Student extends Person {
    private String major;
    public Student(String n, String m)
    {
        super(n);
        major = m;
    }

    public String getDescription()
    {
        return "a Student majoring in " + major;
    }
}
