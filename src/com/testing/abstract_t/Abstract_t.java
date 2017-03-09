package com.testing.abstract_t;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class Abstract_t {
    public static void main(String[] args)
    {
        Student s = new Student("lucy", "computer science");
        Teacher t = new Teacher("mike", "large data");

        Person[] collage = new Person[2];
        collage[0] = s;
        collage[1] = t;

        for (Person p :
                collage) {
            System.out.println(p.getDescription());
        }
    }
}

