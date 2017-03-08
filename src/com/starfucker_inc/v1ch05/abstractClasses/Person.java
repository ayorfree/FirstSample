package com.starfucker_inc.v1ch05.abstractClasses;

/**
 * Created by zhangjiyun on 2017/3/8.
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String x)
    {
        name = x;
    }

    public String getName()
    {
        return name;
    }
}
