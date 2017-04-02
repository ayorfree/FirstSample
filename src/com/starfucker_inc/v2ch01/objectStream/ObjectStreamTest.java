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
        Employee lee = new Employee("lee", 60000, 1987, 3, 4);
        Manager alice = new Manager("alice", 65000, 1985, 4, 2);
        Manager carl = new Manager("carl", 70000, 1985, 3, 4);
        alice.setSecretary(lee);
        carl.setSecretary(lee);

        Employee[] staff = new Employee[3];
        staff[0] = lee;
        staff[1] = alice;
        staff[2] = carl;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("fuck.txt"))) {
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("fuck.txt"))) {
            Employee[] newStaff = (Employee[]) in.readObject();
            newStaff[0].raiseSalary(10);
            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }
        }
    }
}
