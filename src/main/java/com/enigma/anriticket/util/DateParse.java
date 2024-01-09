package com.enigma.anriticket.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateParse {
    public static LocalDate parseStringToLocaleDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            return LocalDate.parse(date, formatter);
        } catch (DateTimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}
