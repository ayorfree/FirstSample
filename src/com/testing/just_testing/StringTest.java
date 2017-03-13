package com.testing.just_testing;

/**
 * Created by zhangjiyun on 2017/3/13.
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String coil = "the ape of naples";
        String coil1 = " the ape of naples ";
        String coil3 = "theapeofnaples";
        String coil4 = "is a great album.";
        String coil5 = "Coil";
        String con = coil + " " + coil4;
        String upper = coil.toUpperCase();
        String lower = upper.toLowerCase();
        String acoil = coil5.toUpperCase();
        int r = coil.compareTo(coil1);

        System.out.println(con);
        System.out.println(upper);
        System.out.println(lower);
        System.out.println(acoil);
        System.out.println(coil1.trim());
        System.out.println(con.length());
        System.out.println(coil.charAt(1));
        System.out.println(r);
        System.out.println(coil1.offsetByCodePoints(1,7));
        System.out.println(coil.equals(coil1));
        System.out.println(coil.indexOf(coil1));
        System.out.println(coil3.substring(3,6));
    }
}
