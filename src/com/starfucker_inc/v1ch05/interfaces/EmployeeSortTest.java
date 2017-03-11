package com.starfucker_inc.v1ch05.interfaces;

import java.util.Arrays;

/**
 * Created by zhangjiyun on 2017/3/11.
 */


public class EmployeeSortTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("lily", 30000);
        staff[1] = new Employee("lucy",35000);
        staff[2] = new Employee("bill",28000);

        Arrays.sort(staff);

        for (Employee e :
                staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}