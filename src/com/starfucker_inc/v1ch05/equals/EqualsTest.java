package com.starfucker_inc.v1ch05.equals;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class EqualsTest {
    public static void main(String[] args)
    {
        Employee alice1 = new Employee("Alice Adams", 75000, 1981,2,3);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1981,2,3);
        Employee bob = new Employee("Bob Brandon", 65000, 1984,3,1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice 1 == alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

        System.out.println("alice1.equals(bob) " + alice1.equals(bob));

        System.out.println("bob.toString() " + bob);

        Manager karl = new Manager("crack", 80000, 1987, 4, 8);
        Manager boss = new Manager("crack", 80000, 1987, 4, 8);
        boss.setBonus(5000);

        System.out.println("boss.toString()" + boss);
        System.out.println("karl.equals(boss）" + karl.equals(boss));
        System.out.println("alice1.hashCode()" + alice1.hashCode());
        System.out.println("alice3.hashCode()" + alice3.hashCode());
        System.out.println("bob.hashCode()" + bob.hashCode());
        System.out.println("karl.hashCode()" + karl.hashCode());
    }


}
