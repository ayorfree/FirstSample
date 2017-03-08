package com.starfucker_inc.v1ch05.abstractClasses;

/**
 * Created by zhangjiyun on 2017/3/8.
 */
public class PersonTest {
    public static void main(String[] args)
    {
        Person[] person = new Person[2];

        person[0] = new Employee("billy", 50000,1989,2,3);
        person[1] = new Student("harry","computer science");

        for (Person p :
                person) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }
}
