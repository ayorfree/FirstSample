package com.starfucker_inc.v1ch13.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhangjiyun on 2017/3/23.
 */
public class PriorityQueueTest2
{
    public static void main(String[] args)
    {
        PriorityQueue<Dog> mylikes = new PriorityQueue<>();
        mylikes.add(new Dog("泰迪", 2000));
        mylikes.add(new Dog("博美", 1000));
        mylikes.add(new Dog("边牧", 2500));
        mylikes.add(new Dog("雄狮", 1800));

        PriorityQueue<Dog> mychoose = new PriorityQueue<>(new Comparator<Dog>() {
           public int compare(Dog a, Dog b)
           {
               String genreA = a.getGenre();
               String genreB = b.getGenre();

               return genreA.compareTo(genreB);
            }
        });

        mychoose.addAll(mylikes);

        System.out.println("as priorityqueue show...");
        for (Dog g :
                mylikes) {
            System.out.println(g.getGenre());
        }

        System.out.println("as priorityqueue show...");
        for (Dog g :
                mychoose) {
            System.out.println(g.getGenre());
        }

        System.out.println("as priorityquene order...");
        while (!mylikes.isEmpty())
        {
            System.out.println(mylikes.remove().getGenre());
        }
    }

}

class Dog implements Comparable<Dog>
{
    private String genre;
    private double price;

    public Dog(String genre, double price)
    {
        this.genre = genre;
        this.price = price;
    }

    public String getGenre()
    {
        return genre;
    }

    public int compareTo(Dog other)
    {
        return Double.compare(price, other.price);
    }
}