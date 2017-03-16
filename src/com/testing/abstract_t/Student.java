package com.testing.abstract_t;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class Student extends Person {
    private String major;
    private static final Logger logger = Logger.getLogger("com.testing.abstract_t");

    public Student(String n, String m)
    {
        super(n);
        major = m;
    }

    public String getDescription()
    {
        logger.setLevel(Level.ALL);
        logger.entering("Person", "getDescription");
        logger.exiting("Person", "getDescription", "my name is " + this.getName() + ", and my major is " + this.major);
        return "my name is " + this.getName() + ", and my major is " + this.major;
    }
}
