package com.testing.just_testing;


/**
 * just testing for inheritance.
 */

public class MultiArrays
{
    public static void main(String[] args)
    {
        Manager lee = new Manager("lee an la");
        Employee ceo = lee;
        lee.setBonus(50000);
        System.out.println("my name is " + lee.getName() + ", and my bonus is " + lee.getBonus());
    }
}

class Manager extends Employee
{
    private double bonus;

    public Manager(String n)
    {
        super(n);
        bonus = 0;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }

    public double getBonus()
    {
        return bonus;
    }
}
class Employee
{
    private String name;

    public Employee(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
}