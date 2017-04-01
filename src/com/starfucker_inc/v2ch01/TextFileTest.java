package com.starfucker_inc.v2ch01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-04-01-下午7:01
 */

public class TextFileTest {
    public static void main(String[] args) throws IOException
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("张三", 70000, 1987, 3, 4);
        staff[1] = new Employee("李四", 78000, 1986, 4, 8);
        staff[2] = new Employee("王五", 80000, 1987, 4, 2);

        try (PrintWriter out = new PrintWriter("employee1.txt", "UTF-8")) {
            writdata(staff, out);
        }

        try (Scanner in = new Scanner(new FileInputStream("employee1.txt"), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writdata(Employee[] employees, PrintWriter out) throws IOException
    {
        out.println(employees.length);
        for (Employee e :
                employees) {
            writeEmployee(e, out);
        }
    }
    private static void writeEmployee(Employee e, PrintWriter out)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.println(e.getName() + "|" + e.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|" +
                (calendar.get(Calendar.MONTH) + 1) + "|" +calendar.get(Calendar.DAY_OF_MONTH));
    }

    private static Employee[] readData(Scanner in)
    {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in)
    {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");

        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);

        return new Employee(name, salary, year, month, day);
    }
}
