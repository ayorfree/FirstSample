package com.testing.abstract_t;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class Teacher extends Person {
    private String subject;

    public Teacher(String n, String m)
    {
        super(n);
        subject = m;
    }

    public String getDescription()
    {
        return "my name is " + this.getName() + ", and my subject is " + this.subject;
    }
}
