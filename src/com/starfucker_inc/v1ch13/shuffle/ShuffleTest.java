package com.starfucker_inc.v1ch13.shuffle;

import java.util.*;

/**
 * sort_testing_
 *
 * @author ayorfree
 * @create 2017-03-25-下午4:20
 */

public class ShuffleTest
{
    public static void main(String[] args)
    {
        List<Integer> pop = new ArrayList<>();
        for (int i = 1; i <= 49; i++)
            pop.add(i);
        Collections.shuffle(pop);
        List<Integer> littlepop = pop.subList(0, 6);
        Collections.sort(littlepop);
        System.out.println(littlepop);
    }
}
