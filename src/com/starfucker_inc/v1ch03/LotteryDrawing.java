package com.starfucker_inc.v1ch03;

import java.util.*;

public class LotteryDrawing
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("可选注的数字的数目是多少？");
        int k = in.nextInt();

        System.out.println("最大可选注的数字是多少？");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];

            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("最佳投注方案：");
        for (int r :
                result) {
            System.out.println(r);
        }
    }
}
