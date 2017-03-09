package com.testing.sbstractClass;

/**
 * Created by zhangjiyun on 2017/3/9.
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
        return "a student major in " + major;
    }
}
