package com.testing.sbstractClass;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class Employee extends Person {
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day)
    {
        super(n);
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f", salary);
    }
}
