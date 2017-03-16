package com.testing.just_testing;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class LotteryOdds
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers you can select each time?");
        int k = in.nextInt();

        System.out.println("What's the biggest number in this lottery?");
        int n = in.nextInt();

        BigInteger odd = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++) {
            odd = odd.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }

        System.out.println("your lotteryodds is " + odd +", good luck!");
    }
}
