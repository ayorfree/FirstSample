package com.testing.objectAnalyzer;

import java.util.ArrayList;

/**
 * Created by zhangjiyun on 2017/3/10.
 */
public class ObjectAnalyzerTest
{
    public static void main(String[] args)
    {
        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
            System.out.println(new ObjectAnalyzer().toString(squares));
        }
    }
}
