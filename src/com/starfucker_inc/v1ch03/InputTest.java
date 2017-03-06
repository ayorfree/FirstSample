package com.starfucker_inc.v1ch03;

import java.util.Scanner;

/**
 * Listing 3.2. InputTest/InputTest.java
 * This program demonstrates console input.
 * Created by zhangjiyun on 2017/3/6.
 */
public class InputTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}
