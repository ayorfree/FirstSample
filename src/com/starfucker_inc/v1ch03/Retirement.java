package com.starfucker_inc.v1ch03;

import java.util.Scanner;

/**
 * Listing 3.3. Retirement/Retirement.java
 * This program demonstrates a <code>while</code> loop.
 * Created by zhangjiyun on 2017/3/6.
 */
public class Retirement
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How much moeny do you want to retirement?");
        double goal = in.nextDouble();

        System.out.println("How much money do you get every year?");
        double payment = in.nextDouble();

        System.out.println("Interest Rate in %: ");
        double InterestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal)
        {
            balance += payment;
            double interest = payment * InterestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retirement in " + years + " years.");
    }
}

