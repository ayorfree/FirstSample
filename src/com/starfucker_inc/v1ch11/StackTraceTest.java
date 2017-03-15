package com.starfucker_inc.v1ch11;

import java.util.Scanner;

/**
 * Created by zhangjiyun on 2017/3/15.
 */

public class StackTraceTest
{
    public static int factorial(int n)
    {
        System.out.println("factorial(" + n +"):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f :
                frames) {
            System.out.println(f);
        }

        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return: " + r);
        return r;
    }

    public static void main(String[] args)
    {
        System.out.println("Enter n: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        factorial(n);
    }
}