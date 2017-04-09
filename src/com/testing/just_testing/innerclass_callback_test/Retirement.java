package com.testing.just_testing.innerclass_callback_test;

import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-04-09-下午10:42
 */

public class Retirement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("How much money you get every year?");
        double salary = in.nextDouble();
        System.out.println("How about interest in %: ");
        int interestRate = in.nextInt();
        int years = 0;
        double balance = 0;

        do {
            balance += salary;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
            System.out.printf("after %d year, total balance is %10.2f, retirement? Y/N?: %n ", years, balance);
        }
        while (in.next().equals("N"));
        System.out.println("finally, yor are retirement.");
    }
}
