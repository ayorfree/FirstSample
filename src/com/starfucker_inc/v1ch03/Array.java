package com.starfucker_inc.v1ch03;

import java.util.Arrays;

/**
 * Created by zhangjiyun on 2017/3/4.
 */
public class Array
{
    public static void main(String[] args)
    {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++)
            a[i] = i;
        String[] b = new String[10];
        for(int i = 1; i < 10; i++)
            b[i] = "";
        System.out.println(a);
        System.out.println(b);

        for (int element : a)
            System.out.println(element);
        System.out.println(Arrays.toString(a));

        int[] smallPrimes = new int[] {2, 3, 4, 5, 6, 7};

    }

}
