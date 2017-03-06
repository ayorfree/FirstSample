package com.starfucker_inc.v1ch03;

import java.util.*;
/**
 * Listing 3.5. LotteryOdds/LotteryOdds.java
 * This program demonstrates a <code>for</code> loop.
 * Created by zhangjiyun on 2017/3/3.
 */
public class LotteryOdds
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to  draw?");
        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        int lotteryOdds = 1;
        for (int i = 1; i <= k ; i++)
        {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }

        System.out.println("your odds are 1 in " + lotteryOdds +". Good Luck!");
    }
}
