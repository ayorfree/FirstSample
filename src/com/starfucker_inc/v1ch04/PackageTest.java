package com.starfucker_inc.v1ch04;

import static java.lang.System.*;

/**
 * This program demonstrates the use of packages.
 * Created by zhangjiyun on 2017/3/7.
 */
public class PackageTest {
    public static void main(String[] args)
    {
        Employee harry = new Employee("Haryy Hecker", 50000,1089,10,1);

        harry.raiseSalary(5);

        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
