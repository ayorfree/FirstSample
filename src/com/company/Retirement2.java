package com.company;

import java.util.*;

public class Retirement2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you contribute every year?");
        double payment = in.nextDouble();

        System.out.print("Current interestRate is %:");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;
        String input;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;

            System.out.printf("After %d years, your retirement will be %f.\n", years, balance);
            System.out.printf("Do you satisify with this balance? (Y/N)");
            input = in.next();
        }
        while (input.equals("N"));
    }
}
