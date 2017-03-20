package com.starfucker_inc.v1ch12.pair2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by zhangjiyun on 2017/3/20.
 */
public class PairTest2 {
    public static void main(String[] args)
    {
        GregorianCalendar[] birthdays =
                {
                        new GregorianCalendar(1990, Calendar.DECEMBER, 9),
                        new GregorianCalendar(1978, Calendar.DECEMBER, 8),
                        new GregorianCalendar(2011, Calendar.DECEMBER, 9),
                        new GregorianCalendar(2009, Calendar.DECEMBER, 6),
                };
        Pair<GregorianCalendar> birthday = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + birthday.getFirst().getTime());
        System.out.println("max = " + birthday.getSecond().getTime());
    }
}

class ArrayAlg
{
    public static <T extends Comparable> Pair<T> minmax(T[] a)
    {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length ; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}
class Pair<T>
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