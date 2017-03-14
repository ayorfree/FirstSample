package com.testing.just_testing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class LotteryOddsDrawing
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("HOW MANY NUMBERS YOU CAN DRWA EACH TIME?");
        int k = in.nextInt();

        System.out.println("BIGGEST NUMBER YOU CAN DRAW?");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] results = new int[k];
        for (int i = 0; i < results.length; i++) {
            int r = (int) (Math.random() * n);
            results[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(results);

        System.out.println("May be the luck numbers is " + Arrays.toString(results));

    }
}
