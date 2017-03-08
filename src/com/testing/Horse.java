package com.testing;

import static java.lang.System.*;

/**
 * Creating a new class for fun.
 * Created by zhangjiyun on 2017/3/7.
 */
public class Horse
{
    public static void main(String[] args)
    {
        out.println("Hello World!");
    }
}

class Horese
{
    private static int nextId = 1;

    private String genre;
    private String name;
    private String colour;
    private double price;
    private int id;

    public Horese(String genre, String name, String colour, double price)
    {
        this.genre = genre;
        this.name = name;
        this.colour = colour;
        this.price = price;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getName()
    {
        return name;
    }

    public String getColour()
    {
        return colour;
    }


    public double getPrice()
    {
        return price;
    }

    public void setId()
    {
        id = nextId;
        nextId++;
    }

    public int getId()
    {
        return id;
    }


    public static int getNextId()
    {
        return nextId;
    }

    public static void main(String[] args)
    {
        Horese[] horseSelling = new Horese[3];

        horseSelling[0] = new Horese("斑马", "轻纵", "灰色",50000);
        horseSelling[1] = new Horese("红马", "清池", "红色",45000);
        horseSelling[2] = new Horese("野马", "竭力", "黑色",60000);

        for (Horese e :
                horseSelling) {
            e.setId();
            out.println(e.getId() + ": 品种——" + e.getGenre() +",名字——" + e.getName()  + ",颜色——" + e.getColour() + ",售价——" + e.getPrice() + "元");
        }

        int n = Horese.getNextId();
        out.println("Next id should be: " + n);
        
    }

}
