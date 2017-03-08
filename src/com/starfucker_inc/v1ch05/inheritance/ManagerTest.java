package com.starfucker_inc.v1ch05.inheritance;

/**
 * Listing 5.1. inheritance/ManagerTest.java
 * This program demonstrates inheritance.
 * @version 3.8 2017-03-08
 * @author ayorfree
 */
public class ManagerTest
{
    public static void main(String[] args)
    {
        Manager boss = new Manager("Carl Cracker", 80000, 1988, 12, 3);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Billy Corgan", 70000, 1987, 3,4);
        staff[2] = new Employee("Thom Yorke",87000,1987,4,14);

        for (Employee e :
                staff) {
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
