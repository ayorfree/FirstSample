package com.testing.just_testing;

import java.util.Scanner;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class retirement2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How about your pament?");
        double payment = in.nextDouble();

        System.out.println("How about interRest in %: ");
        int interRest = in.nextInt();

        int years = 0;
        double balance = 0;

        String input;

        do {
            balance += payment;
            double interest = balance * interRest / 100;
            balance += interest;
            years++;
            System.out.println("After " + years +", your retirement will be " + balance +" dollars. Do you want to retirement? Y/N?");
            input = in.next();
        }while (input.equals("N"));
    }
}
