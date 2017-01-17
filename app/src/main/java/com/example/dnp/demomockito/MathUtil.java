package com.example.dnp.demomockito;

import java.util.Calendar;
import java.util.List;

/**
 * Created by DNP on 1/15/2017.
 */

public class MathUtil {
    public static int getAddition(int a, int b) {
        return a + b;
    }

    public static int getSubtraction(int a, int b) {
        return a - b;
    }

    public static int getMultilication(int a, int b) {
        return a * b;
    }

    public static int getDivision(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Argument divisor is 0");
        return a / b;
    }

    public static String getString(String a, String b) {
        return a + " convert string to " + b;
    }

    public static int dateCalendar(Calendar calendar) {
        return calendar.get(Calendar.DATE);
    }

    public static boolean isMax(int a, int b) {
        return a > b ? true : false;
    }

    public static Calendar dateUpdate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, day);
        return calendar;
    }

    public static MyUser addMyUser(String name, String address, int age) {
        return new MyUser(name, address, age);
    }

    public static String nameFirst(List<MyUser> list) {
        return list.get(0).getName();
    }
}
