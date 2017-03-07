package com.starfucker_inc.v1ch04;

/**
 * Listing 4.4. ParamTest/ParamTest.java
 * This program demonstrates parameter passing in Java.
 * Created by zhangjiyun on 2017/3/6.
 */
public class ParamTest {
    public static void main(String[] args) {
        /*
         * Test 1: Methods don't modify numeric parameters
         */

        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /*
         * Test 2: Methods can change the state of objects parameters
         */

        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before:salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After:salary=" + harry.getSalary());

        /*
         * Test 3: Methods can't attch new objects to object parameters
         */

        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of methond: x=" + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary =" + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of the methond: x=" + x.getName());
        System.out.println("End of the methond: y+" + y.getName());
    }
}
