package com.testing.just_testing;

import java.lang.reflect.Array;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class StringTest
{
    public static void main(String[] args) {
        String coil3 = "theapeofnaples";

        System.out.println(coil3.length());
        System.out.println(coil3.charAt(0));
        System.out.println(coil3.toUpperCase());

        String r = revsor(coil3);

        System.out.println(r.toUpperCase());
    }

    private static String revsor(String s){
        int n = s.length();
        StringBuilder seq = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            seq.append(s.charAt(n - 1 - i));
        }
        return seq.toString();
    }

}


