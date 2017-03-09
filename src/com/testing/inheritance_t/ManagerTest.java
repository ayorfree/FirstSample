package com.testing.inheritance_t;

/**
 * Created by zhangjiyun on 2017/3/9.
 */
public class ManagerTest {
    public static void main(String[] args)
    {
        Manager boss = new Manager("lucy" , 60000, 1976, 2, 3);
        boss.setBonus(5000);

        Employee[] staff = new Employee[2];
        staff[0] = boss;
        staff[1] = new Employee("lily", 50000, 1978, 3,12);

        for (Employee e :
                staff) {
            e.raiseSalary(5);
            System.out.println("name_" + e.getName() + ",salary_" + e.getSalary() +",hireday_" + e.getHireDay());
        }
    }
}
