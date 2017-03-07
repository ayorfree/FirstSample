package com.starfucker_inc.v1ch04;

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("harry", 44444);
        staff[1] = new Employee("lucy", 45454);
        staff[2] = new Employee("cocoh", 45454);

        for (Employee e :
                staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",salary= " + e.getSalary() + ",id=" + e.getId());
        }

        int n = Employee.getNextId();
        System.out.println("Next availabel id is " + n);
    }
}





