package com.starfucker_inc.v1ch13.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * this program demonstrate how to operate linkedlist premiliary.
 * @version 3.23
 * @author ayorfree
 */

public class LinkedListTest
{
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<>();
        a.add("Alice");
        a.add("Caro");
        a.add("Erica");
        a.add("Gloria");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Dick");
        b.add("Flour");
        b.add("Hippo");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext())
        {
           if (aIter.hasNext())
               aIter.next();
           aIter.add(bIter.next());
        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if (bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);
    }
}