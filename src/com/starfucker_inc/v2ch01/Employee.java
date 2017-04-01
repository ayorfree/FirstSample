package com.starfucker_inc.v2ch01;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ayorfree
 * @create 2017-04-01-下午6:57
 */

class Employee {
    private String name;
    private double salary;
    private Date hireDay;

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
        return getClass().getName() + "[name=" + getName() +
                ", salary=" + getSalary() + ", hireDay= " + getHireDay();
    }
}
