package com.starfucker_inc.v2ch01.textFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-04-01-下午8:20
 */

public class TextFileTest {
    private static void writeEmployee(PrintWriter out, Employee e)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.println(e.getName() + "|" + e.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|" +
                (calendar.get(Calendar.MONTH + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH)));
    }

    private static void writeData(PrintWriter out, Employee[] employees)
    {
        out.println(employees.length);
        for (Employee e :
                employees) {
            writeEmployee(out, e);
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

    public static void main(String[] args) throws IOException
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("ALICE" , 70000, 1989, 3, 3);
        staff[1] = new Employee("BOB", 87000, 1976, 3, 4);
        staff[2] = new Employee("Carl", 76000, 1986, 4, 3);

        try (PrintWriter out = new PrintWriter("papers.txt", "UTF-8")) {
            writeData(out, staff);
        }

        try (Scanner in = new Scanner(new FileInputStream("papers.txt"), "UTF-8")){
            Employee[] newStaff = readData(in);
            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }

        }
    }
}
