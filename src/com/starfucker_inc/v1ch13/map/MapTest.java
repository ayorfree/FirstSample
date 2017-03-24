package com.starfucker_inc.v1ch13.map;


import java.util.HashMap;
import java.util.Map;

/**
 * @version 3.24
 * @author ayorfree
 */
public class MapTest
{
    public static void main(String[] args)
    {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7658", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Franceca Cruz"));

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5527", new Employee("Grorge linken"));

        System.out.println(staff.get("157-62-7658"));

        for (Map.Entry< String, Employee > entry:
        staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
    }
}

class Employee
{
    private String name;

    public Employee(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return "[name=" + name +"]";
    }
}
