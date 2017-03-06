package com.starfucker_inc.v1ch03;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args)
    {
        // Math.sin()
        // Math.cos

        double x = 4;
        double y = Math.sqrt(x);

        double z = 9.996;
        int nz = (int) z;
        int oz = (int) Math.round(z);

        String greeting = "Hello";
        String e = ""; // a empty String
        String s = greeting.substring(0, 3);

        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        int age = 13;
        String rating = "PG" + age;

        greeting = greeting.substring(0, 3) + "p!";

        //"Help".equals(greeting);

        System.out.println(y + Math.PI + Math.E);
        out.println(nz);
        out.println(oz);
        out.println(s);

        out.println(message);
        out.println(rating);

        out.println("The answer is " + message);

        out.println(greeting);

        out.println("Help!".equals(greeting));
        out.println("Hello".equalsIgnoreCase("hello"));

        out.println(message.length());
        out.println(message.codePointCount(0,message.length()));

        char first = message.charAt(0);
        char random = message.charAt(7);

        out.println(first);
        out.println(random);

        int index = message.offsetByCodePoints(0, 5);
        int cp = message.codePointAt(index);

        out.println(cp);
        out.println(message.toUpperCase()); //toUpperCase()
        out.println(message.toLowerCase()); //toLowerCase()

        String space = "                   space               ";
        String trimspace = space.trim();

        out.println(trimspace); //trim()




    }
}

