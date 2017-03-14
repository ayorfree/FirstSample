package com.testing.just_testing;

import java.util.Scanner;

/**
 * Created by zhangjiyun on 2017/3/14.
 */
public class SwitchTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Who is the next woman you fucking ?");

        switch (in.nextLine())
        {
            case "zhangsan":
                System.out.println("zhangsan is okay!");
                break;
            case "lisi":
                System.out.println("lisi is so suck!");
                break;
            case "wangwu":
                System.out.println("wangwu is prefer!");
                break;
            default:
                System.out.println("fuck feng!");

        }
    }
}
