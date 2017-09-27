package com.testing.reviewed;

import java.util.GregorianCalendar;
import java.util.Date;

/**
 * review
 *
 * @author ayorfree
 * @create 2017-09-27-下午10:58
 */

class Employee
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("lucy", 30000, 1987, 2, 4);
        staff[1] = new Employee("lily", 35000, 1989, 3,5);
        staff[2] = new Employee("Carl", 40000, 1973,4,12);

        for (Employee e :
                staff) {
            System.out.println("My name is " + e.getName() + ", my salary is " +
                    e.getSalary() + ", and my hireday is " + e.getHireDay());
        }
    }


}
