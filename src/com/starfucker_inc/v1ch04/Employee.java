package com.starfucker_inc.v1ch04;

import java.util.Date;
import java.util.GregorianCalendar;

/**
* Created by zhangjiyun on 2017/3/7.
*/
class Employee
{
    private static int nextId = 1;

    private String name;
    private double salary;
    private Date hireDay;
    private int id;

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public Employee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void setId()
    {
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }
}
