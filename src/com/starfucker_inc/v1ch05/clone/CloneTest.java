package com.starfucker_inc.v1ch05.clone;

/**
 * Created by zhangjiyun on 2017/3/11.
 */
public class CloneTest {
    public static void main(String[] args)
    {
    try

    {
        Employee orignial = new Employee("lily", 40000);
        orignial.setHireDay(2000, 1, 1);
        Employee copy = orignial.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2011, 1, 1);

        System.out.println("orignal=" + orignial);
        System.out.println("copy=" + copy);
    }

    catch (CloneNotSupportedException e)
    {
        e.printStackTrace();
    }
}
}
