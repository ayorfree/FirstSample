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

        System.out.println("How many numbers you can draw?");
        int k = in.nextInt();

        System.out.println("What's the biggest number you can draw?");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] results = new int[k];
        for (int i = 0; i < results.length; i++) {
            results[i] = numbers[(int) (Math.random() * n)];
            numbers[(int) (Math.random() * n)] = numbers[n-1];
            n--;
        }
        Arrays.sort(results);
        System.out.println("May be your odd is " + Arrays.toString(results));

        }
    }
}
