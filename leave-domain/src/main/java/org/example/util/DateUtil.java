package org.example.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author
 */
public class DateUtil {

    public static final LocalDateTime DEFAULT_DATE_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public static LocalDate parseDate(String dateStr) throws ParseException {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) throws ParseException {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }
}
