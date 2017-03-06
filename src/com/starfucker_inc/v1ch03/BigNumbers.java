package com.starfucker_inc.v1ch03;

import java.math.BigInteger;

public class BigNumbers
{
    public static void main(String[] args)
    {
        BigInteger a = BigInteger.valueOf(100);
        BigInteger b = a.add(BigInteger.valueOf((300)));
        BigInteger c = b.multiply(a.add(BigInteger.valueOf(400)));

        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
    }
}
