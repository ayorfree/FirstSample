package com.starfucker_inc.v1ch12.pair3;

import java.util.Date;
import java.util.GregorianCalendar;

public class PairTest3
{
    public static void main(String[] args)
    {
        Manager ceo = new Manager("billy corgan" , 500000, 1987,3,4);
        Manager cfo = new Manager("thom yorke", 500000, 1987, 3, 4);

        ceo.setBonus(1000000);
        cfo.setBonus(900000);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBoddies(buddies);

        Manager[] managers = {ceo, cfo};
        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", and second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", and second: " + result.getSecond().getName());
    }

    public static void printBoddies(Pair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
    {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
    {
        minmaxBonus(a, result);
        ArrayAlg.swap(result);
    }
}

class ArrayAlg
{
    public static boolean hasNulls(Pair<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p)
    {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getSecond();
        p.setSecond(p.getFirst());
        p.setFirst(t);
    }
}

class Pair<T>
{
    T first;
    T second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    public void setFirst(T first)
    {
        this.first = first;
    }

    public void setSecond(T second)
    {
        this.second = second;
    }
}

class Manager extends Employee
{
    private double bonus;

    public Manager(String n, double s, int year, int month, int day)
    {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }


}

class Employee
{
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
}