package com.starfucker_inc.v1ch13.treeset;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest
{
    public static void main(String[] args)
    {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Jack", 2321));
        parts.add(new Item("Ann", 1986));
        parts.add(new Item("Lcuy", 2198));
        System.out.println(parts);

        SortedSet<Item> SortedByDescription = new TreeSet<>(new Comparator<Item>() {
            public int compare(Item a, Item b)
            {
                String descrA = a.getDescription();
                String descrB = b.getDescription();

                return descrA.compareTo(descrB);
            }
        });

        SortedByDescription.addAll(parts);
        System.out.println(SortedByDescription);
    }
}



