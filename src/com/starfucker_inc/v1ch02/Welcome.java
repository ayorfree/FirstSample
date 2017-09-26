package com.starfucker_inc.v1ch02;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class Welcome
{
    public static void main(String[] args)
    {
        String[] greeting = new String[3];
        greeting[0] = "小张铮";
        greeting[1] = "回南京";
        greeting[2] = "来上班";

        for (String g :
               greeting) {
            System.out.print(g);
        }
    }
}

