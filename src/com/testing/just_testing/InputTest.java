package com.testing.just_testing;


import java.util.Date;
import java.util.Locale;


/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class InputTest
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        System.out.printf("%tc\n", new Date());
        System.out.printf("%1$s %2$tB %2$te, %2$ty\n", "Due Date:", new Date());
        System.out.printf("%s %tB %<te, %<ty", "Due Date:", new Date());
        System.out.println("My name is ");

    }
}
