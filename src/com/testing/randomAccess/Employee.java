package com.testing.randomAccess;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ayorfree
 * @create 2017-04-02-上午10:08
 */

class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 40 + 8 + 4 + 4 + 4;

    public Employee(){}

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public String toString()
    {
        return getClass().getName()
                + "[name=" + getName()
                + ", salary=" + getSalary()
                + ", hireDay=" + getHireDay()
                +"]";
    }
}
