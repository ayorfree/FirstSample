package com.testing;

import java.util.*;
/**
 * Created by zhangjiyun on 2017/3/3.
 */
public class Switch
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Choose favrite number:(1, 2, 3, 4)");

        int choise = in.nextInt();

        switch (choise) {
            case 1:
                System.out.print("he yue");
                break;
            case 2:
                System.out.print("he lu");
                break;
            case 3:
                System.out.print("fan yan");
                break;
            case 4:
                System.out.print("pan pan");
                break;
            default:
                System.out.print("other chicks");
                break;
        }

    }
}