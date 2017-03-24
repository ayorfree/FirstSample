package com.starfucker_inc.v1ch13.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest
{
    public static void main(String[] args)
    {
        Map<Price, Dog> dogs = new HashMap<>();

        Price k = new Price("1800");

        dogs.put(new Price("2000"), new Dog("博美"));
        dogs.put(k, new Dog("松狮"));
        dogs.put(new Price("2100"), new Dog("边牧"));
        dogs.put(new Price("1300"), new Dog("泰迪"));

        System.out.println(dogs);

        dogs.remove(k);

        dogs.put(new Price("3000"), new Dog("巴哥"));

        for (Map.Entry<Price, Dog> entry :
            dogs.entrySet()) {
            Price price = entry.getKey();
            Dog genre = entry.getValue();
            System.out.println("price=" + price +", genre=" + genre);
        }
    }
}

class Dog
{
    private String genre;

    public Dog(String genre)
    {
        this.genre = genre;
    }

    public String toString()
    {
        return "[genre=" + genre +"]";
    }
}

class Price
{
    private String price;

    public Price(String price)
    {
        this.price = price;
    }

    public String toString()
    {
        return "[price=" + price + "]";
    }
}