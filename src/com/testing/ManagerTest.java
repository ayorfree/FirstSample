package com.testing;

/**
 * Created by zhangjiyun on 2017/3/8.
 */
public class ManagerTest {
    public static void main(String[] args)
    {
        Manager boss = new Manager("bill", 30000, 1989, 2, 3);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("york", 30000, 1989, 4 ,4);
        staff[2] = new Employee("lucy", 30000,1987, 4, 8);

        for (Employee e :
                staff) {
            e.raiseSalary(10);

            System.out.println("name:" + e.getName() +",salary:" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }
    }
}
