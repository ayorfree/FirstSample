package com.testing.sbstractClass;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class PersonTest {
    public static void main(String[] args)
    {
        Person[] person = new Person[2];
        person[0] = new Student("jack", "computer science");
        person[1] = new Employee("lucy", 45000, 1988, 2, 3 );

        for (Person p :
                person) {
            System.out.println(p.getDescription());
        }
    }
}
