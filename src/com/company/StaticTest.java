package com.company;

public class StaticTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhangsan", 99999);
        staff[1] = new Employee("lisi", 88888);
        staff[2] = new Employee("wangwu", 65333);

        for (Employee e :
                staff) {
            e.setId();
            System.out.println("name=" + e.getName() +",id=" + e.getId() +",salary=" + e.getSalary());
        }

        int n = Employee.getNextId();
        System.out.println("Next avaliable id is:" + n);
    }
}

class Employee
{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setId()
    {
        id = nextId;
        nextId++;
    }

    public int getId()
    {
        return id;
    }

    public static int getNextId()
    {
        return nextId;
    }
}


