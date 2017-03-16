package com.testing.abstract_t;

import java.util.logging.Logger;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public abstract class Person {
    private String name;

    private static final Logger logger = Logger.getLogger("com.testing.abstract_t");

    public Person(String n)
    {
        logger.entering("Person", "<init>");
        name = n;
        logger.exiting("Person", "<init>");
    }

    public String getName()
    {
        logger.entering("Person", "getName");
        logger.exiting("Person", "getName", name);
        return name;
    }

    public abstract String getDescription();
}
