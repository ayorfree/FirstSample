package com.starfucker_inc.v1ch12.pair1;

/**
 * @version 2017.3.20
 * @author ayor
 */

public class PairTest1
{
    public static void main(String[] args)
    {
        String[] coil = {"in", "my", "blood", "it", "is", "soul"};
        Pair<String> ape = ArraysAlg.minmax(coil);
        System.out.println("min = " + ape.getFirst());
        System.out.println("max = " + ape.getSecond());
    }
}

class ArraysAlg
{
    public static Pair<String> minmax(String[] a)
    {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
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