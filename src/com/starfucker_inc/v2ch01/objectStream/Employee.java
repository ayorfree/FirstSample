package com.starfucker_inc.v2ch01.objectStream;

/**
 * @author ayorfree
 * @create 2017-04-02-下午2:08
 */

import java.io.*;
import java.util.*;

public class Employee implements Serializable
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee()
    {
    }

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

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString()
    {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
                + "]";
    }
}
