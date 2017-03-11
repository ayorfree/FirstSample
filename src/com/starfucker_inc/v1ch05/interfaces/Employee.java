package com.starfucker_inc.v1ch05.interfaces;

/**
 * Created by zhangjiyun on 2017/3/11.
 */

public class Employee implements Comparable<Employee>
{
    private String name;
    private double salary;

    public Employee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int compareTo(Employee other)
    {
        return Double.compare(salary, other.salary);
    }
}
