package com.starfucker_inc.v1ch05.clone;

/**
 * Created by zhangjiyun on 2017/3/11.
 */
public class CloneTest
{
    public static void main(String[] args) {

        try {
            Employee original = new Employee("bill", 50000);
            Employee copy = original.clone();
            original.setHireDay(2000, 2, 3);
            copy.raiseSalary(5);
            copy.setHireDay(2011, 3, 3);

            System.out.println("orignial:" + original);
            System.out.println("copy:" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
