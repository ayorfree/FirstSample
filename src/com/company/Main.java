package com.company;

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

        System.out.println(y + Math.PI + Math.E);
        out.println(nz);
        out.println(oz);
    }
}

