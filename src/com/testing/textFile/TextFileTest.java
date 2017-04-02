package com.testing.textFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-04-02-上午9:39
 */

public class TextFileTest
{
    public static void main(String[] args) throws IOException
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("alice", 80000, 1987, 4, 4);
        staff[1] = new Employee("bob", 78000, 1897, 3, 3);
        staff[2] = new Employee("carl", 76000, 1986, 3, 4);

        try (PrintWriter out = new PrintWriter("Java.txt", "UTF-8")) {
            writeData(out, staff);
        }

        try (Scanner in = new Scanner(new FileInputStream("Java.txt"), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writeEmployee(PrintWriter out, Employee e)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.println(e.getName() + "|"
                + e.getSalary() + "|" + calendar.get(Calendar.YEAR)
        + "|" + (calendar.get(Calendar.MONTH) + 1) +
        "|" + calendar.get(Calendar.DAY_OF_MONTH));
    }

    private static void writeData(PrintWriter out, Employee[] employees)
    {
        out.println(employees.length);
        for (Employee  employee:
                employees) {
            writeEmployee(out, employee);
        }
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
}


