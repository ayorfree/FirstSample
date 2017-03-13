package com.testing.just_testing;

import java.util.Scanner;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class Retirement
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you want get for you retirement?");
        double goal = in.nextDouble();

        System.out.println("How much money do you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("What about the interRest?");
        int interRest = in.nextInt();

        int years = 0;
        double balance = 0;

        while (balance < goal)
        {
            balance += payment;
            double interest = balance * interRest / 100;
            balance += interest;
            years++;
        }
        System.out.println("you need " + years +" years to retirement.");
    }
}
