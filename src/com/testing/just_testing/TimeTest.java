package com.testing.just_testing;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * @author ayorfree
 * @create 2017-10-20-下午2:13
 */

public class TimeTest {
    public static void main(String[]args) {
        LocalDate today = LocalDate.now();
        LocalDate a = today.plusDays(5);
        LocalDate b = today.minusMonths(3);
        LocalDate c = today.withDayOfMonth(3);
        int e = today.getDayOfMonth();
        int f = today.getDayOfYear();
        LocalTime t = LocalTime.now();
        DayOfWeek g = today.getDayOfWeek();
        LocalDateTime dt = LocalDateTime.now();


        List<Object> dayList = new ArrayList<>();
        dayList.add(today);
        dayList.add(g);
        dayList.add(e);
        dayList.add(t);
        dayList.add(a);
        dayList.add(b);
        dayList.add(c);
        dayList.add(dt);


        for (Object o :
                dayList) {
            System.out.println(o);
        }
    }
}
