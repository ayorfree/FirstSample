package com.testing.sbstractClass;

/**
 * @version
 * @author
 * Created by zhangjiyun on 2017/3/9.
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
