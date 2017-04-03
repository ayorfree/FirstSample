package com.testing.pair;

import java.io.*;

/**
 * @author ayorfree
 * @create 2017-04-03-下午10:17
 */

public class PairTest
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Dog[] dogs = new Dog[4];
        dogs[0] = new Dog("贵宾", 1200);
        dogs[1] = new Dog("边牧", 1300);
        dogs[2] = new Puppy("博美", 1500, "boomei");
        dogs[3] = new Puppy("泰迪", 1400, "taidii");

        Puppy a = (Puppy) dogs[2];
        Puppy b = (Puppy) dogs[3];


        for (Dog dog :
                dogs) {
            System.out.println(dog);
        }

        Pair<Dog> bigdog = new Pair<>(dogs[0], dogs[1]);
        Pair<Puppy> littledog = new Pair<>(a, b);

        System.out.println(bigdog.first.getId());
        System.out.println(littledog.second.getId());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dog.txt"))){
            out.writeObject(dogs);
            out.writeObject(bigdog);
            out.writeObject(littledog);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("dog.txt"))){
            Dog[] newDogs = (Dog[]) in.readObject();
            Pair<Dog> newBigdog = (Pair<Dog>) in.readObject();
            Pair<Puppy> newPuppy = (Pair<Puppy>) in.readObject();

            for (Dog dog:
                 newDogs) {
                System.out.println(dog);
            }
            System.out.println(newBigdog);
            System.out.println(newPuppy);
        }
    }
}

class Pair<T> implements Serializable
{
    T first;
    T second;

    public Pair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    public String toString()
    {
        return first.toString() + second.toString();
    }
}

class Dog implements Serializable
{
    private String genre;
    private double price;
    private static int nextid = 1;
    private int id;

    public Dog(String g, double p)
    {
        genre = g;
        price = p;
        id = nextid;
        nextid++;
    }

    public String getGenre()
    {
        return genre;
    }

    public double getPrice()
    {
        return price;
    }


    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "[genre is "
                + getGenre()
                + ", price is "
                + getPrice()
                + ", id is "
                + getId() + "]";
    }
}

class Puppy extends Dog
{
    private String alias;

    public Puppy(String g, double p, String a)
    {
        super(g, p);
        alias = a;
    }

    public String getAlias()
    {
        return alias;
    }

    public String toString()
    {
        return "[genre is "
                + getGenre()
                + ", price is "
                + getPrice()
                + ", id is "
                + getId()
                + ", alias is "
                + getAlias()
                +"]";
    }
}