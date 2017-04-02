package com.testing.randomAccess;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author ayorfree
 * @create 2017-04-02-上午10:26
 */

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("alice", 70000, 1987, 4, 4);
        staff[1] = new Employee("bob", 68000, 1986, 3, 4);
        staff[2] = new Employee("carl", 78999, 1976, 3, 2);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("oop.txt"))) {
            for (Employee e : staff) {
                writeData(out, e);
            }
        }

        try (RandomAccessFile in = new RandomAccessFile("oop.txt", "r")) {
            int n = (int) (in.length()/ Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];

            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }

    public static void writeData(DataOutput out, Employee e) throws IOException
    {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH) + 1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Employee readData(DataInput in) throws IOException
    {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);
    }
}
