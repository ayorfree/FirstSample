package com.starfucker_inc.v1ch12.pair2;

import java.util.GregorianCalendar;

public class PairTest2
{
    public static void main(String[] args)
    {
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(2011, GregorianCalendar.JANUARY, 3),
                new GregorianCalendar(1988, GregorianCalendar.JANUARY, 4),
                new GregorianCalendar(1876, GregorianCalendar.JANUARY, 3),
                new GregorianCalendar(1899, GregorianCalendar.JANUARY, 2),
        };

        Pair<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);

        System.out.println("min = " + mm.getFirst().getTime());
        System.out.println("max = " + mm.getSecond().getTime());
    }
}

class ArrayAlg
{
    public static <T extends Comparable> Pair<T> minmax(T[] a)
    {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}

class Pair<T extends Comparable>
{
    private T first;
    private T second;

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
}