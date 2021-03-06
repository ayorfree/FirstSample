package com.starfucker_inc.v1ch03;

import java.util.Scanner;

/**
 * Listing 3.4. Retirement2/Retirement2.java
 * This program demonstrates a <code>do/while</code> loop.
 * Created by zhangjiyun on 2017/3/6.
 */
public class Retirement2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("Interest Rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            year++;

            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);

            System.out.printf("Ready to retire = ? (Y/N) \n");
            input = in.next();
        }
        while (input.equals("N"));
    }

}
