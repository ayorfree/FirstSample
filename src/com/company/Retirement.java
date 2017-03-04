package com.company;

import java.util.*;

public class Retirement
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you want to retirement?");
        double goal = in.nextDouble();

        System.out.print("How much money do you contribute every year?");
        double payment = in.nextDouble();

        System.out.print("Interest Rate is %:");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal)
        {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("you can retirement after " + years + " years.");
    }
}
