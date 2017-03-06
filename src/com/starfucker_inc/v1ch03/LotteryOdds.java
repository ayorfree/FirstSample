package com.starfucker_inc.v1ch03;

import java.util.*;
/**
 * Created by zhangjiyun on 2017/3/3.
 */
public class LotteryOdds
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.print("What's the highest number you can draw?");
        int n = in.nextInt();

        int lotteryodd = 1;
        for (int i = 1; i <= k; i++)
            lotteryodd = lotteryodd * (n - i + 1) / i;

        System.out.println("Your oods are 1 in " + lotteryodd + ". Good Luck!");
    }

}
