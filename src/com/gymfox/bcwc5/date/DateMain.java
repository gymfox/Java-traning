package com.gymfox.bcwc5.date;

public class DateMain {
    public static void main(String[] args) throws InvalidDateException {
        Date date = new Date(31, 1, 1937);
        System.out.println(date);

        Date first = new Date(29, 2, 1900);
        System.out.println(first);
    }
}
