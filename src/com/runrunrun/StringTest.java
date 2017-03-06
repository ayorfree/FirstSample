package com.runrunrun;

/**
 * Created by zhangjiyun on 2017/3/4.
 */
public class StringTest {
    public static void main(String[] args)
    {
        String s = "incredible";
        String s1 = s.substring(2, 4);

        System.out.println(s1);

        String i = "I";
        String relation = " hate";
        String u = " you";
        String re = i + relation + u;
        int n = re.length();
        int cpCount = re.codePointCount(0, re.length());
        char first = re.charAt(0);
        char last = re.charAt(9);
        int cpat = re.codePointAt(0);
        int offset = re.offsetByCodePoints(0,1);

        System.out.println(re);
        System.out.println("the truth is " + re);
        System.out.println(i + relation + u);
        System.out.println(re.equals(u));
        System.out.println("Hello".equalsIgnoreCase("hello"));
        System.out.println(n);
        System.out.println(cpCount);
        System.out.println(first);
        System.out.println(last);
        System.out.println(cpat);
        System.out.println(offset);

    }
}
