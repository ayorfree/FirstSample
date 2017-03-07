package com.starfucker_inc.v1ch04;

import java.util.*;

/**
 * Created by zhangjiyun on 2017/3/5.
 */
public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("张继云", 87000,1988, 2, 21);
        staff[1] = new Employee("刘文", 85000,1988, 3, 21);
        staff[2] = new Employee("马可吐", 78000,1991, 4, 19);

        for (Employee e :
                staff)
            e.raiseSalary(5);

        for (Employee e :
                staff)
            System.out.println("name=" + e.getName() + ", salary="  + e.getSalary() +   ", hireDay="  + e.getHireDay());
    }
}

