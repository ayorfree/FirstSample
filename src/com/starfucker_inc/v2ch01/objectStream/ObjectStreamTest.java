package com.starfucker_inc.v2ch01.objectStream;

import java.io.*;

/**
 * @author ayorfree
 * @create 2017-04-02-下午2:08
 */

public class ObjectStreamTest
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Employee lee = new Employee("lee", 40000, 1972, 3, 4);
        Manager wang = new Manager("wang", 42000, 1976, 3 ,9);
        Manager zhang = new Manager("zhang", 47000, 1970, 3, 8);

        wang.setSecretary(lee);
        zhang.setSecretary(lee);

        Employee[] staff = new Employee[3];
        staff[0] = lee;
        staff[1] = wang;
        staff[2] = zhang;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pop.txt"))){
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pop.txt"))){
            Employee[] newStaff = (Employee[]) in.readObject();

            newStaff[0].raiseSalary(10);

            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }
        }
    }
}
