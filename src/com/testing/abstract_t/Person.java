package com.testing.abstract_t;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public abstract class Person {
    private String name;

    public Person(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public abstract String getDescription();
}
