package com.starfucker_inc.v1ch03;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Listing 3.6. BigIntegerTest/BigIntegerTest.java
 * This program uses big numbers to compute the odds of winning the grand prize in a lottery.
 * Created by zhangjiyun on 2017/3/6.
 */
public class BigIntegerTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers you need to draw?");
        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <=k; i++)
        {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1).divide(BigInteger.valueOf(i)));
        }

        System.out.println("your odds are 1 in " + lotteryOdds +". Good Luck!");
    }
}
